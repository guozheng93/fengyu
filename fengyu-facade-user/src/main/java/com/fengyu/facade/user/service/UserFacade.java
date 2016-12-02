package com.fengyu.facade.user.service;

import com.fengyu.facade.user.entity.User;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/1
 */
public interface UserFacade {

    User findByLoginName(String loginName);
}
