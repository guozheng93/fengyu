package com.fengyu.crowdfunding.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdfundingItemPropValuePO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CrowdFundingItemPropValueDao extends BaseDao<CrowdfundingItemPropValuePO>{

    public List<Map<String,Object>> getList4CrowdfundingItemPropValueByItmPropId(Integer propId);
    public Integer physicsDelete(CrowdfundingItemPropValuePO crowdfundingItemPropValuePO);
}
