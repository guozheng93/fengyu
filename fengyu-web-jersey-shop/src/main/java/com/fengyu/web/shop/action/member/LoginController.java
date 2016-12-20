package com.fengyu.web.shop.action.member;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.common.web.jersey.wrapper.ResponseWrapper;
import com.fengyu.facade.user.address.service.AddressFacade;
import com.fengyu.facade.user.education.service.EducationFacade;
import com.fengyu.facade.user.info.service.InfoFacade;
import com.fengyu.facade.user.login.entity.po.UserPO;
import com.fengyu.facade.user.login.entity.vo.UserVO;
import com.fengyu.facade.user.login.service.UserFacade;
import com.fengyu.facade.user.work.service.WorkFacade;
import com.fengyu.web.shop.util.token.Constant;
import com.fengyu.web.shop.util.token.JwtUtil;
import com.fengyu.web.shop.util.token.ResponseUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
@Path("/user")
public class LoginController extends BaseController {

    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private AddressFacade addressFacade;

    @Autowired
    private EducationFacade educationFacade;

    @Autowired
    private InfoFacade infoFacade;

    @Autowired
    private WorkFacade workFacade;

    @Autowired
    private JwtUtil jwt;



//    @Autowired
//    private LoginFacade loginFacade;
//
//    @Autowired
//    private TokenFacade tokenFacade;

//    @POST
//    @Path("login")
//    public String login(String args)
//    {
//        List<String> messages = new ArrayList<String>();
//        UserVO userVO= JSON.parseObject(args, UserVO.class);
//        ResponseWrapper responseWrapper = new ResponseWrapper();
//        //登录支持  手机号和邮箱
//        UserPO user =  userFacade.findByLoginName(userVO.getLoginName());
//
//        //用户名错误
//        if(user == null){
//            responseWrapper.setResponseStatus(300);
//            messages.add("用户名错误");
//        }
//        //效验密码
//        if(user.getPassword().equals(userVO.getPassword())){
//            //未禁用，执行登录操作
//            if(!user.getIsValid()){
//                try {
//                    String subject = JwtUtil.generalSubject(user);
//                    String token = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
//                    String refreshToken = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_REFRESH_TTL);
//                }
//
//                //记录用户状态
//                //tokenFacade.insert(new Token(user.getId(),null,new Date(),new Date(),true));
//                messages.add("登录成功");
//            }else{ //已禁用
//                responseWrapper.setResponseStatus(300);
//                messages.add("用户名已禁用");
//            }
//        }else{
//            responseWrapper.setResponseStatus(300);
//            messages.add("密码错误");
//        }
//        responseWrapper.setMessages(messages);
//        //记录登录历史
//        //loginFacade.insert(new Login(user.getId(),"ip",responseWrapper.getResponseStatus()));
//        return JSON.toJSONString(responseWrapper);
//    }
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public String login(String args)
    {
        try {
            UserVO userVO= JSON.parseObject(args, UserVO.class);
            //登录支持  手机号和邮箱
            UserPO user =  userFacade.findByLoginName(userVO.getLoginName());
            //用户名错误
            if(user == null){
                return ResponseUtil.exception("账号错误");
            }
            //效验密码
            if(user.getPassword().equals(userVO.getPassword())){
                //未禁用，执行登录操作
                if(!user.getIsValid()){
                    String subject = JwtUtil.generalSubject(user);
                    String token = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
                    String refreshToken = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_REFRESH_TTL);
                    JSONObject jo = new JSONObject();
                    jo.put("token", token);
                    jo.put("refreshToken", refreshToken);
                    return ResponseUtil.success(jo);
                }else{ //已禁用
                    return ResponseUtil.exception("账号已禁用");
                }
            }else{
                return ResponseUtil.exception("密码错误");
            }
        } catch (Exception e) {
            logger.error(e);
            return ResponseUtil.unKonwException();
        }
    }


}
