package com.fengyu.common.core.interceptor;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.utils.ReflectHelper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * 分页拦截器，用于拦截需要进行分页查询的操作，然后对其进行分页处理。
 * 利用拦截器实现Mybatis分页的原理：
 * 要利用JDBC对数据库进行操作就必须要有一个对应的Statement对象，Mybatis在执行Sql语句前就会产生一个包含Sql语句的Statement对象，而且对应的Sql语句
 * 是在Statement之前产生的，所以我们就可以在它生成Statement之前对用来生成Statement的Sql语句下手。在Mybatis中Statement语句是通过RoutingStatementHandler对象的
 * prepare方法生成的。所以利用拦截器实现Mybatis分页的一个思路就是拦截StatementHandler接口的prepare方法，然后在拦截器方法中把Sql语句改成对应的分页查询Sql语句，之后再调用
 * StatementHandler对象的prepare方法，即调用invocation.proceed()。
 * 对于分页而言，在拦截器里面我们还需要做的一个操作就是统计满足当前条件的记录一共有多少，这是通过获取到了原始的Sql语句后，把它改为对应的统计语句再利用Mybatis封装好的参数和设
 * 置参数的功能把Sql语句中的参数进行替换，之后再执行查询记录数的Sql语句进行总记录数的统计。
 *
 */
@Intercepts(
        {@Signature(type=StatementHandler.class,method="prepare",args={Connection.class}),
                @Signature(type = Executor.class, method = "query", args = {
                        MappedStatement.class, Object.class, RowBounds.class,
                        ResultHandler.class })
        })
public class PageInterceptor implements Interceptor {
    private String dialect = ""; //数据库方言
    private String pageSqlId = ""; //mapper.xml中需要拦截的ID(正则匹配)

    public Object intercept(Invocation invocation) throws Throwable {
        //对于StatementHandler其实只有两个实现类，一个是RoutingStatementHandler，另一个是抽象类BaseStatementHandler，
        //BaseStatementHandler有三个子类，分别是SimpleStatementHandler，PreparedStatementHandler和CallableStatementHandler，
        //SimpleStatementHandler是用于处理Statement的，PreparedStatementHandler是处理PreparedStatement的，而CallableStatementHandler是
        //处理CallableStatement的。Mybatis在进行Sql语句处理的时候都是建立的RoutingStatementHandler，而在RoutingStatementHandler里面拥有一个
        //StatementHandler类型的delegate属性，RoutingStatementHandler会依据Statement的不同建立对应的BaseStatementHandler，即SimpleStatementHandler、
        //PreparedStatementHandler或CallableStatementHandler，在RoutingStatementHandler里面所有StatementHandler接口方法的实现都是调用的delegate对应的方法。
        //我们在PageInterceptor类上已经用@Signature标记了该Interceptor只拦截StatementHandler接口的prepare方法，又因为Mybatis只有在建立RoutingStatementHandler的时候
        //是通过Interceptor的plugin方法进行包裹的，所以我们这里拦截到的目标对象肯定是RoutingStatementHandler对象。
        if(invocation.getTarget() instanceof RoutingStatementHandler){
            RoutingStatementHandler statementHandler = (RoutingStatementHandler)invocation.getTarget();
            StatementHandler delegate = (StatementHandler) ReflectHelper.getFieldValue(statementHandler, "delegate");
            BoundSql boundSql = delegate.getBoundSql();
            Object obj = boundSql.getParameterObject();
            //通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
            MappedStatement mappedStatement = (MappedStatement)ReflectHelper.getFieldValue(delegate, "mappedStatement");
            //检测是否匹配拦截规则
            String mapperId=mappedStatement.getId();
            mapperId=mapperId.substring(mapperId.lastIndexOf("."));
            Pattern pattern = Pattern.compile(this.pageSqlId);
            Matcher matcher = pattern.matcher(mapperId);
            if (obj instanceof PageBean&&matcher.matches()) {
                PageBean page = (PageBean) obj;
                String sql = boundSql.getSql();
                if(sql.toLowerCase().indexOf(" limit ")==-1)
                {
                    //拦截到的prepare方法参数是一个Connection对象
                    Connection connection = (Connection)invocation.getArgs()[0];
                    //获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句

                    //给当前的page参数对象设置总记录数
                    this.setTotalRecord(page,
                            mappedStatement, connection);
                    //获取行号Sql语句
                    String pageSql = this.getRowNumSql4Mysql(new StringBuffer(sql));
                    //获取分页Sql语句
                    pageSql = this.getPageSql(page, pageSql);
                    //利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句
                    ReflectHelper.setFieldValue(boundSql, "sql", pageSql);
                }

            }
        }
        return invocation.proceed();
    }

    /**
     * 给当前的参数对象page设置总记录数
     *
     * @param page Mapper映射语句对应的参数对象
     * @param mappedStatement Mapper映射语句
     * @param connection 当前的数据库连接
     */
    private void setTotalRecord(PageBean page,
                                MappedStatement mappedStatement, Connection connection) {
        //获取对应的BoundSql，这个BoundSql其实跟我们利用StatementHandler获取到的BoundSql是同一个对象。
        //delegate里面的boundSql也是通过mappedStatement.getBoundSql(paramObj)方法获取到的。
        BoundSql boundSql = mappedStatement.getBoundSql(page);
        //获取到我们自己写在Mapper映射语句中对应的Sql语句
        String sql = boundSql.getSql();
        //通过查询Sql语句获取到对应的计算总记录数的sql语句
        String countSql = this.getCountSql(sql);
        //通过BoundSql获取对应的参数映射
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        //利用Configuration、查询记录数的Sql语句countSql、参数映射关系parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。
        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, page);
        //通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, page, countBoundSql);
        //通过connection建立一个countSql对应的PreparedStatement对象。
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(countSql);
            //通过parameterHandler给PreparedStatement对象设置参数
            parameterHandler.setParameters(pstmt);
            //之后就是执行获取总记录数的Sql语句和获取结果了。
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int totalRecord = rs.getInt(1);
                //给当前的参数page对象设置总记录数
                page.setTotalCount(totalRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 给当前的参数对象page设置总记录数
     *
     * @param page Mapper映射语句对应的参数对象
     * @param connection 当前的数据库连接
     */
    private void setTotalRecord4Mysql(PageBean page,Connection connection) {

        //通过connection建立一个countSql对应的PreparedStatement对象。
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement("SELECT FOUND_ROWS()");
            //之后就是执行获取总记录数的Sql语句和获取结果了。
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int totalRecord = rs.getInt(1);
                //给当前的参数page对象设置总记录数
                page.setTotalCount(totalRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据原Sql语句获取对应的查询总记录数的Sql语句
     * @param sql
     * @return
     */
    private String getCountSql(String sql) {
        sql=sql.toUpperCase();
        int index =sql .indexOf("FROM");
        return "select count(*) " + sql.substring(index);
    }

    /**
     * 根据page对象获取对应的分页查询Sql语句，这里只做了两种数据库类型，Mysql和Oracle
     * 其它的数据库都 没有进行分页
     *
     * @param page 分页对象
     * @param sql 原sql语句
     * @return
     */
    private String getPageSql(PageBean page, String sql) {
        StringBuffer sqlBuffer = new StringBuffer(sql);
        if ("mysql".equalsIgnoreCase(dialect)) {
            return getMysqlPageSql(page, sqlBuffer);
        } /*else if ("oracle".equalsIgnoreCase(dialect)) {
            return getOraclePageSql(page, sqlBuffer);
        }*/
        return sqlBuffer.toString();
    }

    /**
     * 获取Mysql数据库的分页查询语句
     * @param page 分页对象
     * @param sqlBuffer 包含原sql语句的StringBuffer对象
     * @return Mysql数据库分页语句
     */
    private String getMysqlPageSql(PageBean page, StringBuffer sqlBuffer) {
        //计算第一条记录的位置，Mysql中记录的位置是从0开始的。
//	   System.out.println("page:"+page.getPage()+"-------"+page.getRows());
        int offset = (page.getCurrentPage() - 1) * page.getPageCount();
        sqlBuffer.insert(0,"SELECT A.* FROM ( ");
        sqlBuffer.append(" ) A limit ").append(offset).append(",").append(page.getPageCount());
        return sqlBuffer.toString();
    }

    /**
     * 获取Mysql数据库的分页查询语句
     * @param sqlBuffer 包含原sql语句的StringBuffer对象
     * @return Mysql数据库分页语句
     */
    private String getRowNumSql4Mysql(StringBuffer sqlBuffer) {
        if(sqlBuffer.toString().indexOf("@rownum")==-1)
        {
            sqlBuffer=new StringBuffer(sqlBuffer.toString().toUpperCase().replaceFirst("SELECT","SELECT @rownum:=0,"));
            sqlBuffer.insert(0,"SELECT @rownum:=@rownum+1 rownum, A.* FROM (");
            sqlBuffer.append(") A");
        }

        return sqlBuffer.toString();
    }

/*    *//**
     * 获取Oracle数据库的分页查询语句
     * @param page 分页对象
     * @param sqlBuffer 包含原sql语句的StringBuffer对象
     * @return Oracle数据库的分页查询语句
     *//*
    private String getOraclePageSql(Page<?> page, StringBuffer sqlBuffer) {
        //计算第一条记录的位置，Oracle分页是通过rownum进行的，而rownum是从1开始的
        int offset = (page.getCurrentPage() - 1) * page.getPageSize() + 1;
        sqlBuffer.insert(0, "select u.*, rownum r from (").append(") u where rownum < ").append(offset + page.getRows());
        sqlBuffer.insert(0, "select * from (").append(") where r >= ").append(offset);
        //上面的Sql语句拼接之后大概是这个样子：
        //select * from (select u.*, rownum r from (select * from t_user) u where rownum < 31) where r >= 16
        return sqlBuffer.toString();
    }*/


    /**
     * 拦截器对应的封装原始对象的方法
     */
    public Object plugin(Object arg0) {
        // TODO Auto-generated method stub
        if (arg0 instanceof StatementHandler) {
            return Plugin.wrap(arg0, this);
        } else {
            return arg0;
        }
    }

    /**
     * 设置注册拦截器时设定的属性
     */
    public void setProperties(Properties p) {

    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getPageSqlId() {
        return pageSqlId;
    }

    public void setPageSqlId(String pageSqlId) {
        this.pageSqlId = pageSqlId;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(".*Java$");
        Matcher matcher = pattern.matcher("不是人Java");
        boolean b= matcher.matches();
        System.out.println(b);

        /*Pattern pattern = Pattern.compile("^Java.*");
        Matcher matcher = pattern.matcher("Java不是人");
        boolean b= matcher.matches();*/
        /*StringBuffer sqlBuffer=new StringBuffer(" SELECT            A.ID            ,A.REC_ID            ,A.REC_LOGIN_NAME            ,A.send_id            ,A.SEND_LOGIN_NAME            ,A.status            ,A.STATUSNAME            ,A.message            ,A.message_type            ,A.message_type_NAME            ,A.title            ,A.mark            ,A.create_time        FROM        (            SELECT                A.id                ,E.ID AS REC_ID                ,CONCAT(LEFT(E.EMAIL,LOCATE('@',E.EMAIL)*0.5),'***',RIGHT(E.EMAIL,LENGTH(E.EMAIL)-LOCATE('@',E.EMAIL)+1)) REC_LOGIN_NAME                ,A.send_id                ,'系统消息' SEND_LOGIN_NAME                ,COALESCE(B.status,0) AS status                ,COALESCE(D.DESCRIPTION,'未读') AS STATUSNAME                ,A.message                ,A.message_type                ,C.DESCRIPTION AS message_type_NAME                ,A.title                ,A.mark                ,DATE_FORMAT(A.create_time,'%Y-%m-%d %r (%W)') as create_time            FROM MSG_TEXT A                LEFT JOIN MSG B                    ON A.ID=B.MESSAGE_ID                    AND B.rec_id=121                LEFT JOIN biz_dictionary C                    ON A.message_type=C.VALUE                    AND C.TYPE='MSGTYPE'                LEFT JOIN biz_dictionary D                    ON A.message_type=D.VALUE                    AND D.TYPE='MSGSTATUS'                JOIN user E                    ON E.id=121              WHERE A.MESSAGE_TYPE ='SYSTEMMASS'                  AND A.group_id='ALL'                  AND A.create_time <=DATE_SUB(now(), interval 3 month)            UNION ALL            SELECT                A.id                ,E.ID AS REC_ID                ,CONCAT(LEFT(E.EMAIL,LOCATE('@',E.EMAIL)*0.5),'***',RIGHT(E.EMAIL,LENGTH(E.EMAIL)-LOCATE('@',E.EMAIL)+1)) REC_LOGIN_NAME                ,A.send_id                ,'系统消息' SEND_LOGIN_NAME                ,COALESCE(B.status,0) AS status                ,COALESCE(D.DESCRIPTION,'未读') AS STATUSNAME                ,A.message                ,A.message_type                ,C.DESCRIPTION AS message_type_NAME                ,A.title                ,A.mark                ,DATE_FORMAT(A.create_time,'%Y-%m-%d %r (%W)') as create_time            FROM MSG_TEXT A                JOIN MSG B                    ON A.ID=B.MESSAGE_ID                    AND B.rec_id=121                LEFT JOIN biz_dictionary C                    ON A.message_type=C.VALUE                    AND C.TYPE='MSGTYPE'                LEFT JOIN biz_dictionary D                    ON A.message_type=D.VALUE                    AND D.TYPE='MSGSTATUS'                JOIN user E                    ON E.id=121              WHERE A.MESSAGE_TYPE ='SYSTEMMASS'                AND A.group_id='SELECTED'                AND A.create_time <=DATE_SUB(now(), interval 3 month)            ) AS A            ORDER BY A.create_time DESC");
        sqlBuffer=new StringBuffer(sqlBuffer.toString().toUpperCase().replaceFirst("SELECT","SELECT @rownum:=0,"));
        sqlBuffer.insert(0,"SELECT @rownum:=@rownum+1 rownum, A.* FROM (");
        sqlBuffer.append(") A");
        System.out.println(sqlBuffer.toString());*/

    }
}