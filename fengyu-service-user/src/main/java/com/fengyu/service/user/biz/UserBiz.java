package com.fengyu.service.user.biz;

import com.fengyu.facade.user.entity.User;
import com.fengyu.service.user.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/1
 */
@Service("userBiz")
public class UserBiz {

    @Resource
    private UserDao userDao;

    public User findByLoginName(String loginName) {

        return  userDao.findByLoginName(loginName);
    }
}
