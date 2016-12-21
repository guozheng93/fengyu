package com.fengyu.common.web.jersey.controller;

import com.alibaba.dubbo.common.json.JSON;
import com.fengyu.common.core.base.service.BaseService;
import com.fengyu.common.exception.MapperSupport.CommonExceptionHandler;
import com.fengyu.common.exception.MapperSupport.CommonExceptionType;
import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.common.utils.string.StrUtil;
import com.fengyu.common.web.jersey.token.JwtUtil;
import com.fengyu.common.web.jersey.utils.UdpGetClientMacAddr;
import com.fengyu.common.web.jersey.wrapper.ResponseWrapper;

import com.fengyu.facade.user.login.entity.po.UserPO;
import com.fengyu.facade.user.login.entity.vo.UserVO;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.*;

/**
 */
public class BaseController {

    private static final Log LOG = LogFactory.getLog(BaseController.class);

    private ResponseWrapper response;

    public Integer pageNum;
    @Context
    protected SecurityContext securityContext;

    @Context
    HttpServletRequest webRequest;

    public Integer getUserId()
    {
        try{
            String token = webRequest.getHeader("token");
            Claims claims = new JwtUtil().parseJWT(token);
            UserPO userPO= com.alibaba.fastjson.JSON.parseObject(claims.getSubject(), UserPO.class);
            return  userPO.getId();
        }catch (Exception e){
            return null;
        }
    }

    public UserVO getUser()
    {
        UserVO user=(UserVO)securityContext.getUserPrincipal();
        return user;
    }
    /**
     * 编码类型 ISO-8859-1.
     */
    // private static final String ISO8859_1 = "iso8859-1";
    /**
     * 编码类型 UTF-8.
     */
    private static final String UTF_8 = "utf-8";
    

    public ResponseWrapper getResponse() {
        return response;
    }

    public void setResponse(ResponseWrapper response) {
        this.response = response;
    }
    
    /**
     * @author junz
     * @date 2016/12/4 19:59
     * @description 调用service 直接封装到ResponseWrapper中
     * @param
     * @return
    **/
    public ResponseWrapper doServiceAndResponse(BaseService service, String methodName, Object... args) throws InvocationTargetException {
        ResponseWrapper response=new ResponseWrapper();
        PageBean page=new PageBean();
        Method method = null;
        Class[] paramType=args==null?null:new Class[args.length];
        if(args!=null)
        {
            for (int i=0;i<args.length;i++)
            {

                if(args[i] instanceof Map)
                {
                    paramType[i]=Map.class;
                }else if(args[i] instanceof List)
                {
                    paramType[i]=List.class;
                }else
                {
                    paramType[i]=args[i].getClass();
                }
            }
        }

        try {
            method = service.getClass().getMethod(methodName,paramType);

            Object obj=method .invoke( service ,args);
            if(!(obj instanceof Integer))
            {
                if(obj instanceof List)
                    page.setRecordList((List)obj);
               /* else if(obj instanceof PageBean)
                {
                    page= (PageBean) obj;
                }*/
                else
                {
                    List list=new ArrayList();
                    list.add(obj);
                    page.setRecordList(list);
                }
                page.setNumPerPage(page.getRecordList().size());
                response.setResponseBody(page);
            }else
            {
                Map hashMap=new HashMap();
                hashMap.put("id",obj);
                List list=new ArrayList();
                list.add(hashMap);
                page.setRecordList(list);
                response.setResponseBody(page);
            }
        } catch (NoSuchMethodException e) {
            throw  new CommonExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);
        }  catch (IllegalAccessException e) {
            throw  new CommonExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);
        }
        return response;
    }

    /**
     * 如果没有值则默认返回1.
     *
     * @author WuShuicheng.
     */
    private int getPageNum(HttpServletRequest req) {
        // 当前页数
        String pageNumStr = req.getParameter("pageNum");
        int pageNum = 1;
        if (StringUtils.isNotBlank(pageNumStr)) {
            pageNum = Integer.valueOf(pageNumStr);
        }
        return pageNum;
    }
    /**
     * 获取每页记录数（DWZ-UI分页查询参数）.<br/>
     * 如果没有值则默认返回15.
     *
     * @author WuShuicheng.
     */
    private int getNumPerPage(HttpServletRequest req) {
        String numPerPageStr = req.getParameter("numPerPage");
        int numPerPage = 20;
        if (StringUtils.isNotBlank(numPerPageStr)) {
            numPerPage = Integer.parseInt(numPerPageStr);
        }
        return numPerPage;
    }

    /**
     * 获取分页参数，包含当前页、每页记录数.
     *
     * @return PageParam .
     */
    public PageParam getPageParam(HttpServletRequest req) {
        return new PageParam(getPageNum(req), getNumPerPage(req));
    }


    /**
     * 取得当前web应用的根路径
     *
     * @return
     */
    public String getWebRootPath(HttpServletRequest req) {
        return req.getServletContext().getRealPath("/");
    }

    /**
     * 添加cookie
     *
     * @param path
     * @param key
     * @param value
     * @param maxAge
     */
    public void addCookie(HttpServletResponse res,String path, String key, String value, int maxAge) {
        Cookie cookie = new Cookie(key, value);
        if (path != null) {
            cookie.setPath(path);
        }
        cookie.setMaxAge(maxAge);
        res.addCookie(cookie);
    }
    /**
     * 添加cookie
     *
     * @param key
     * @param value
     */
    public void addCookie(HttpServletResponse res,String key, String value) {
        Cookie cookie = new Cookie(key, value);
        res.addCookie(cookie);
    }

    /**
     * 根据参数名从HttpRequest中获取Double类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return DoubleValue or null .
     */
    public Double getDouble(HttpServletRequest req,String key) {
        String value = req.getParameter(key);
        if (StringUtils.isNotBlank(value)) {
            return Double.parseDouble(value);
        }
        return null;
    }

    /**
     * 根据参数名从HttpRequest中获取Integer类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return IntegerValue or null .
     */
    public Integer getInteger(HttpServletRequest req,String key) {
        String value = req.getParameter(key);
        if (StringUtils.isNotBlank(value)) {
            return Integer.parseInt(value);
        }
        return null;
    }

    /**
     * 根据参数名从HttpRequest中获取Long类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return LongValue or null .
     */
    public Long getLong(HttpServletRequest req,String key) {
        String value = req.getParameter(key);
        if (StringUtils.isNotBlank(value)) {
            return Long.parseLong(value);
        }
        return null;
    }

    /**
     * 根据参数名从HttpRequest中获取String类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return String or null .
     */
    public String getString(HttpServletRequest req,String key) {
        return req.getParameter(key);
    }

    /**
     * 根据参数名从HttpRequest中获取String类型的参数值，无值则返回"" .
     *
     * @param key
     *            .
     * @return String .
     */
    public String getString_UrlDecode_UTF8(HttpServletRequest req,String key) {
        try {
            return URLDecoder.decode(this.getString(req,key), UTF_8);
        } catch (Exception e) {
            return "";
        }

    }

    public String getString_UrlDecode_GBK(HttpServletRequest req,String key) {
        try {
            return new String(getString(req,key.toString()).getBytes("GBK"), "UTF-8");
        } catch (Exception e) {
            return "";
        }

    }
    /**
     * 根据参数名从HttpRequest中获取String[] 类型的参数值 有 返回字符串数组 无 返回null;
     *
     * @param key
     *            .
     * @return String[] or null .
     */
    public String[] getStringArr(HttpServletRequest req,String key) {
        return req.getParameterValues(key);
    }

    /**
     * 根据参数名从HttpRequest中获取Integer[] 类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return Integer[] or null .
     */
    public Integer[] getIntegerArr(HttpServletRequest req,String key) {
        String[] values = req.getParameterValues(key);
        Integer[] returnArr = null;
        if (values != null) {
            int valueLength = values.length;
            returnArr = new Integer[valueLength];
            for (int i = 0; i < valueLength; i++) {
                returnArr[i] = Integer.parseInt(values[i]);
            }
        }
        return returnArr;
    }

    /**
     * 根据参数名从HttpRequest中获取Long[] 类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return Long[] or null .
     */
    public Long[] getLongArr(HttpServletRequest req,String key) {
        String[] values = req.getParameterValues(key);
        Long[] returnArr = null;
        if (values != null) {
            int valueLength = values.length;
            returnArr = new Long[valueLength];
            for (int i = 0; i < valueLength; i++) {
                returnArr[i] = Long.parseLong(values[i]);
            }
        }
        return returnArr;
    }

    /**
     * 根据参数名从HttpRequest中获取Long[] 类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return Long[] or null .
     */
    public Double[] getDoubleArr(HttpServletRequest req,String key) {
        String[] values = req.getParameterValues(key);
        Double[] returnArr = null;
        if (values != null) {
            int valueLength = values.length;
            returnArr = new Double[valueLength];
            for (int i = 0; i < valueLength; i++) {
                returnArr[i] = Double.parseDouble(values[i]);
            }
        }
        return returnArr;
    }

    /**
     *
     * @param propertyName
     *            要校验的属性中文名称，如“登录名”.
     * @param property
     *            要校验的属性值，如“gzzyzz”.
     * @param isRequire
     *            是否必填:true or false.
     * @param minLength
     *            最少长度:大于或等于0，如果不限制则可请设为0.
     * @param maxLength
     *            最大长度:对应数据库字段的最大长度，如不限制则可设为0.
     * @return 校验结果消息，校验通过则返回空字符串 .
     */
    protected String lengthValidate(String propertyName, String property, boolean isRequire, int minLength, int maxLength) {
        int propertyLenght = StrUtil.strLengthCn(property);
        if (isRequire && propertyLenght == 0) {
            return propertyName + "不能为空，"; // 校验不能为空
        } else if (isRequire && minLength != 0 && propertyLenght < minLength) {
            return propertyName + "不能少于" + minLength + "个字符，"; // 必填情况下校验最少长度
        } else if (maxLength != 0 && propertyLenght > maxLength) {
            return propertyName + "不能多于" + maxLength + "个字符，"; // 校验最大长度
        } else {
            return ""; // 校验通过则返回空字符串 .
        }
    }

    /**
     * 获取客户端的IP地址
     *
     * @return
     */
    public String getIpAddr(HttpServletRequest req) {
        String ipAddress = null;
        ipAddress = req.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }

        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
    /**
     * 获取客户端MAC地址
     *
     * @return
     */
    public String getClientMacAddr(HttpServletRequest req) {
        try {
            return new UdpGetClientMacAddr(this.getIpAddr(req)).GetRemoteMacAddr();
        } catch (SocketTimeoutException e) {
            return "00:00:00:00";
        } catch (Exception e) {
            return "00:00:00:00";
        }

    }
    /**
     * 获取请求中的参数值
     *
     * @return
     */
    public Map<String, Object> getParamMap(HttpServletRequest req) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        Map map = req.getParameterMap();
        Set keys = map.keySet();
        for (Object key : keys) {
            parameters.put(key.toString(), this.getString(req,key.toString()));
        }
        return parameters;
    }

    /**
     * 获取请求中的参数值，如果参数值为null刚转为空字符串""
     *
     * @return
     */
    public Map<String, Object> getParamMap_NullStr(HttpServletRequest req) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        Map map = req.getParameterMap();
        Set keys = map.keySet();
        for (Object key : keys) {
            String value = this.getString(req,key.toString());
            if (value == null){
                value = "";
            }
            parameters.put(key.toString(), value);
        }
        return parameters;
    }

    /**
     * 获取请求中的参数值
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Map<String, Object> getParamMap_Utf8(HttpServletRequest req) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        Map map = req.getParameterMap();
        Set keys = map.keySet();
        for (Object key : keys) {
            parameters.put(key.toString(), this.getString_UrlDecode_UTF8(req,key.toString()));
        }
        return parameters;
    }

    /**
     * 获取请求中的参数值
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Map<String, Object> getParamMap_GBK(HttpServletRequest req) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        Map map = req.getParameterMap();
        Set keys = map.keySet();
        for (Object key : keys) {
            parameters.put(key.toString(), this.getString_UrlDecode_GBK(req,key.toString()));
        }
        return parameters;
    }
    /**
     * 获取refererUrl
     */
    public String getRefererUrl(HttpServletRequest req) {
        return req.getHeader("referer");
    }

    /**
     * 获取字符串的编码
     *
     * @param str
     * @return
     */
    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }

    public String nullParamOfJsonFilter(Object obj)
    {
        String jsonStr= "";
        /*try {
            //设置过滤json格式
            JsonConfig jsonConfig = new JsonConfig();
            PropertyFilter filter = new PropertyFilter() {
                public boolean apply(Object object, String fieldName, Object fieldValue) {
                    if(fieldValue instanceof List){
                        List<Object> list = (List<Object>) fieldValue;
                        if (list.size()==0) {
                            return true;
                        }
                    }
                    return null == fieldValue || "".equals(fieldValue);
                }
            };
            jsonConfig.setJsonPropertyFilter(filter);
            JSONArray jsonArray = JSONArray.fromObject(obj,jsonConfig);
            JSONObject jsonObject = new JSONObject();
            jsonStr = JSON.json(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            jsonStr=JSON.json(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
