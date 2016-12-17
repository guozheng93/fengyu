package com.fengyu.service.work.dao;

import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.work.entity.po.WorkPO;
import com.fengyu.service.work.biz.WorkBiz;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/17
 */
@MyBatisDao
public interface WorkDao extends BaseDao<WorkPO> {
}
