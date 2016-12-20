package com.fengyu.crowdfunding.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingEntityPO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CrowdFundingEntityDao extends BaseDao<CrowdFundingEntityPO>{
    public List<Map<String,Object>> getPageList4CrdFdEntity(Map map);
}
