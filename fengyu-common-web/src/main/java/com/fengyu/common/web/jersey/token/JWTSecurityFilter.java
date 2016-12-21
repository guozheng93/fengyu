package com.fengyu.common.web.jersey.token;

import com.fengyu.facade.user.login.entity.po.UserPO;
import com.fengyu.facade.user.login.service.UserFacade;
import io.jsonwebtoken.Claims;
import org.glassfish.jersey.server.ContainerRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Priority;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/20
 */
@Provider
@Priority(Priorities.AUTHENTICATION)//优先级最高
//实现该拦截器借口
//@Provider可以自动注册
@PreMatching        //这个必须添加，否则无法拦截请求
public class JWTSecurityFilter implements ContainerRequestFilter{

    final static org.apache.log4j.Logger logger = org.apache.log4j.LogManager.getLogger(JWTSecurityFilter.class.getName());

    @Autowired
    UserFacade userFacade;

    @Context
    ServletContext context;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String path = ((ContainerRequest) containerRequestContext).getPath(true).toLowerCase();
        System.out.println("authorizationHeader path is :"+path);
        if(path.contains("member")){
            //获取头信息中的token
            MultivaluedMap<String, String> headerMap = ((ContainerRequest) containerRequestContext).getHeaders();
            String token = ((ContainerRequest) containerRequestContext).getHeaderString("token");
            try{
                Claims claims = new  JwtUtil().parseJWT(token);
                if(token == null ||  claims == null || claims.getSubject() == null){
                    throw new TokenException();
                }
            }catch (Exception e){
                throw new TokenException();
            }
        }else{
            return;
        }
    }

    public static void main(String[] args) {
        UserPO user = new UserPO();
        user.setId(11);
        String subject = JwtUtil.generalSubject(user);
        try {
            System.out.println("加密前====>"+user.getId());
            String token = new JwtUtil().createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
            System.out.println("加密后====>"+token);
            Claims claims = new JwtUtil().parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE0ODIyNDk2MjAsInN1YiI6In");
            System.out.println("解密后====>"+claims.getSubject());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
