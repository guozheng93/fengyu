package com.fengyu.service.user.dao;

import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.user.entity.po.UserPO;

import java.util.Map;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/1
 */
@MyBatisDao
public interface UserDao extends BaseDao<UserPO> {

    Map findByLoginName(String loginName);
}
