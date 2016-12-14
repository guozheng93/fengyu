package com.fengyu.web.shop.action.user;


import com.fengyu.common.enums.ErrorEnum;
import com.fengyu.common.result.ResponseResult;
import com.fengyu.common.utils.MD5;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.facade.user.entity.vo.UserVO;
import com.fengyu.facade.user.service.UserFacade;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserFacade userFacade;

    /**
     * 登录
     * @return
     */
    /*@RequestMapping("/login")
    @ResponseBody
    public ResponseResult login(HttpServletRequest request) {
        ResponseResult result = new ResponseResult();
        String loginName = getString(request,"loginName");
        String password = getString(request,"password");
        if(StringUtils.isBlank(loginName)){
            log.debug("mobile:{},code:{} >>登录：用户名为空", loginName);
            result.setError(ErrorEnum.TOKEN_TIMEOUT, "用户名为空");
        }
        UserVO user = userFacade.findByLoginName(loginName);
        MD5 m = new MD5();
        // 无效的帐号
        if (user == null) {
            if (user == 1) {
                log.debug("mobile:{},code:{} >>登录：帐号错误", loginName);
                result.setError(ErrorEnum.TOKEN_TIMEOUT, "帐号错误");
            }
            if (password.equals(user.getPassword()) || m.getMD5ofStr(password).equals(user.getPassword())) {
                return result;
            }else{
                log.debug("mobile:{},code:{} >>登录：密码错误", loginName);
                result.setError(ErrorEnum.TOKEN_TIMEOUT, "密码错误");
            }
        }
        return result;
    }*/
}
