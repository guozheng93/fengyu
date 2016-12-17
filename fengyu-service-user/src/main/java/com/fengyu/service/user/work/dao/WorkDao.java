package com.fengyu.service.user.work.dao;

import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.user.work.entity.po.WorkPO;
import com.fengyu.service.user.work.biz.WorkBiz;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/17
 */
@MyBatisDao
public interface WorkDao extends BaseDao<WorkPO> {
}
