package com.fengyu.crowdfunding.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingFocusPO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CrowdFundingFocusDao extends BaseDao<CrowdFundingFocusPO>{
    public Integer selectTotal(CrowdFundingFocusPO crowdFundingFocusPO);

    public List<Map<String,Object>> getFocusList(CrowdFundingFocusPO crowdFundingFocusPO);
}
