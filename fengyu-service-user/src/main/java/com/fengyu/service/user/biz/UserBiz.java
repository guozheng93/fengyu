package com.fengyu.service.user.biz;

import com.fengyu.facade.user.entity.vo.UserVO;
import com.fengyu.service.user.dao.UserDao;
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

    public Map findByLoginName(String loginName) {
        Map user=userDao.findByLoginName(loginName);
        return null;
    }
}
