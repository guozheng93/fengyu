package com.fengyu.web.shop.action.member.user;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.common.web.jersey.wrapper.ResponseWrapper;
import com.fengyu.facade.user.login.entity.vo.UserVO;
import com.fengyu.facade.user.login.service.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Component
@Path("/user")
public class IndexController extends BaseController {

    @Autowired
    private UserFacade userFacade;

    @POST
    @Path("list")
    public String login(String args)
    {
//        UserVO userVO= JSON.parseObject(args, UserVO.class);
//        ResponseWrapper responseWrapper= null;
//        String jsonStr="";
//        //登录支持  手机号和邮箱
//        UserVO user =  userFacade.findByLoginName(userVO.getLoginName());
//
//        //用户名错误
//        if(user == null){
//
//        }
//        //效验密码
//        if(user.getPassword().equals(userVO.getPassword())){
//
//        }
//        //未禁用，执行登录操作
//        if(!user.getValid()){
//
//            //记录用户状态
//
//        }else{ //已禁用
//
//        }
        return null;
    }
}
