package com.fengyu.crowdfunding.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingPO;

@MyBatisDao
public interface CrowdFundingDao extends BaseDao<CrowdFundingPO>{

    public Integer submitCrowdFunding(Integer id);
}
