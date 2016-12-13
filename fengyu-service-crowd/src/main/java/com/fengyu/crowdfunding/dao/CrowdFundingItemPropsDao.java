package com.fengyu.crowdfunding.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdfundingItemPropsPO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CrowdFundingItemPropsDao extends BaseDao<CrowdfundingItemPropsPO> {
    public List<Map<String,Object>> getList4CrowdfundingItemProps11(Map map);
    public Integer insert4Map(CrowdfundingItemPropsPO crowdfundingItemPropsPO);
    public Integer physicsDelete4Map(CrowdfundingItemPropsPO crowdfundingItemPropsPO);
}
