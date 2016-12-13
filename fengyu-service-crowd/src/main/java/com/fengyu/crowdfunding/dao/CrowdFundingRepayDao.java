package com.fengyu.crowdfunding.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingRepayPO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CrowdFundingRepayDao extends BaseDao<CrowdFundingRepayPO>{
    public List<Map<String, Object>> getList4CrowdFundingRepay22(Map map);
    public Integer deleteByMap(CrowdFundingRepayPO crowdFundingRepayPO);
}
