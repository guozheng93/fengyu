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

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;


@Component
@Path("/user")
public class RegisterController extends BaseController {

    private static final Logger logger = LogManager.getLogger(RegisterController.class);

    @Autowired
    private UserFacade userFacade;

    @POST
    @Path("register")
    public String login(String args)
    {
        try {
            UserPO userPO = JSON.parseObject(args, UserPO.class);
            userPO.setAuth(false);
            userPO.setIsValid(true);
            userPO.setCreateTime(new Date());
            userPO.setUpdateTime(new Date());
            userPO.setLastTime(new Date());
            userPO.setUsername("fy"+userPO.getPhone());
            long result = userFacade.insert(userPO);
            if (result>0){
                return ResponseUtil.success();
            }else{
                return ResponseUtil.exception("注册错误");
            }
        } catch (Exception e) {
            return ResponseUtil.unKonwException();
        }
    }

}
