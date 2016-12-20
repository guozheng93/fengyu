package com.fengyu.service.user.login.biz;

import com.fengyu.facade.user.login.entity.po.UserPO;
import com.fengyu.facade.user.login.entity.vo.UserVO;
import com.fengyu.service.user.login.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/1
 */
@Service("userBiz")
public class UserBiz {

    @Resource
    private UserDao userDao;

    public UserPO findByLoginName(String loginName) {
        UserPO userPO=userDao.findByLoginName(loginName);
        return userPO;
    }
}
