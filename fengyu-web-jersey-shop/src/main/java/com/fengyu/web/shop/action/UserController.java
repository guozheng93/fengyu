package com.fengyu.web.shop.action;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.CommonExceptionType;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.common.web.jersey.wrapper.ResponseWrapper;
import com.fengyu.facade.crowdfunding.entity.vo.*;
import com.fengyu.facade.crowdfunding.exception.CrowdExceptionHandler;
import com.fengyu.facade.crowdfunding.service.CrowdFundingEntityFacade;
import com.fengyu.facade.user.entity.vo.UserVO;
import com.fengyu.facade.user.service.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@Component
@Path("/user")
public class UserController extends BaseController {

    @Autowired
    private UserFacade userFacade;

    @POST
    @Path("login")
    public String login(String args)
    {
        UserVO userVO= JSON.parseObject(args, UserVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        //登录支持  手机号和邮箱
        UserVO user =  userFacade.findByLoginName(userVO.getLoginName());

        //用户名错误
        if(user == null){

        }
        //效验密码
        if(user.getPassword().equals(userVO.getPassword())){

        }
        //未禁用，执行登录操作
        if(!user.getValid()){

            //记录用户状态

        }else{ //已禁用

        }
        return jsonStr;
    }
}
