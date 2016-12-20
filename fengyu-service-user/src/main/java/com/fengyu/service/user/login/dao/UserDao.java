package com.fengyu.service.user.login.dao;

import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.user.login.entity.po.UserPO;
import com.fengyu.facade.user.login.entity.vo.UserVO;

import java.util.Map;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/1
 */
@MyBatisDao
public interface UserDao extends BaseDao<UserPO> {

    UserPO findByLoginName(String loginName);
}
