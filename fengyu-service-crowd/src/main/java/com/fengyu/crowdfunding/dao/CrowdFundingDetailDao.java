package com.fengyu.crowdfunding.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.common.entity.BaseEntity;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingDetailPO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CrowdFundingDetailDao extends BaseDao<CrowdFundingDetailPO>{

}
