package com.fengyu.crowdfunding.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingItemPO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CrowdFundingItemDao extends BaseDao<CrowdFundingItemPO> {
    public List<Map<String, Object>> getList4CrdFdBottomItem();
}
