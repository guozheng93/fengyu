package com.fengyu.crowdfunding.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingAcctPO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CrowdFundingAcctDao extends BaseDao<CrowdFundingAcctPO> {
    public List<Map<String,Object>> getList4AcctByMap(Map map);
}
