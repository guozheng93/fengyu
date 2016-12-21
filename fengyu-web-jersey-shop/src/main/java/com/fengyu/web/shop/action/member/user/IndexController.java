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
@Path("/member/user")
public class IndexController extends BaseController {


    @POST
    @Path("list")
    public String login(String args)
    {
        return null;
    }
}
