package com.fengyu.service.user.dao.impl;

import com.fengyu.common.core.dao.BaseDaoImpl;
import com.fengyu.facade.user.entity.User;
import com.fengyu.service.user.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/1
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

    @Override
    public User findByLoginName(String loginName) {
        return super.getSqlSession().selectOne("findByLoginName",loginName);
    }
}
