package com.fengyu.facade.user.impl;

import com.alibaba.fastjson.JSON;
import com.fengyu.facade.user.entity.vo.UserVO;
import com.fengyu.facade.user.service.UserFacade;
import com.fengyu.service.user.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserVO findByLoginName(String loginName) {
        UserVO userVO=JSON.parseObject(JSON.toJSONString(userBiz.findByLoginName(loginName)),UserVO.class);
        return userVO;
    }
}
