package com.fengyu.crowdfunding.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingPO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CrowdFundingAuditDao extends BaseDao<CrowdFundingPO>{

    public List<Map<String,Object>> getList4CrdFdAudit(Map map);
}
