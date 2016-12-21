package com.fengyu.web.shop.action.member;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.common.web.jersey.token.JwtUtil;
import com.fengyu.facade.user.address.service.AddressFacade;
import com.fengyu.facade.user.education.service.EducationFacade;
import com.fengyu.facade.user.info.service.InfoFacade;
import com.fengyu.facade.user.login.entity.po.UserPO;
import com.fengyu.facade.user.login.entity.vo.UserVO;
import com.fengyu.facade.user.login.service.UserFacade;
import com.fengyu.facade.user.work.service.WorkFacade;
import com.fengyu.web.shop.util.token.Constant;
import com.fengyu.web.shop.util.token.ResponseUtil;
import io.jsonwebtoken.Claims;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


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

    @POST
    @Path("login")
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
                    Claims claims = new JwtUtil().parseJWT(token);
                    System.out.println(claims);
                    String json = claims.getSubject();
                    System.out.println(json);
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

    @POST
    @Path("tokenError")
    @Produces(MediaType.APPLICATION_JSON)
    public String tokenError(String args)
    {
        return  ResponseUtil.TokenError("操作超时");
    }


}
