package com.fengyu.facade.user.impl;

import com.fengyu.facade.user.entity.User;
import com.fengyu.facade.user.service.UserFacade;
import com.fengyu.service.user.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/1
 */
@Service("userFacade")
public class UserFacadeImpl implements UserFacade{

    @Autowired
    private UserBiz userBiz;

    @Override
    public User findByLoginName(String loginName) {
        return userBiz.findByLoginName(loginName);
    }
}
