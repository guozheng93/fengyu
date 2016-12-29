package com.fengyu.facade.user.login.service.impl;

import com.alibaba.fastjson.JSON;
import com.fengyu.facade.user.login.entity.po.UserPO;
import com.fengyu.facade.user.login.entity.vo.UserVO;
import com.fengyu.facade.user.login.service.UserFacade;
import com.fengyu.service.user.login.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author guoz
 * @version V1.0
 * @date 2016/12/1
 */
@Service("userFacade")
public class UserFacadeImpl implements UserFacade{

    @Autowired
    private UserBiz userBiz;

    @Override
    public UserPO findByLoginName(String loginName) {
        UserPO userPO=JSON.parseObject(JSON.toJSONString(userBiz.findByLoginName(loginName)),UserPO.class);
        return userPO;
    }

    @Override
    public long update(UserPO userPO) {
        return userBiz.update(userPO);
    }

    @Override
    public long insert(UserPO userPO) {
        return userBiz.insert(userPO);
    }
}
