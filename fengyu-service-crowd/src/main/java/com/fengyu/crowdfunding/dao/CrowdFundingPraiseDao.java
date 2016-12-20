package com.fengyu.crowdfunding.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingPraisePO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CrowdFundingPraiseDao extends BaseDao<CrowdFundingPraisePO>{
    public Integer selectTotal(CrowdFundingPraisePO crowdFundingPraisePO);

    public List<Map<String,Object>> getPraiseList(CrowdFundingPraisePO crowdFundingPraisePO);
}
