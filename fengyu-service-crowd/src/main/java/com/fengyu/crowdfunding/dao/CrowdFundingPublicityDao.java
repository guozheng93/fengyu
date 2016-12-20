package com.fengyu.crowdfunding.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingFocusPO;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingPublicityImgPO;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingPublicityPO;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CrowdFundingPublicityDao extends BaseDao<CrowdFundingPublicityPO>{

    public List<Map<String,Object>> getPageList4CrdFdEntityDynamics(CrowdFundingPublicityPO CrowdFundingPublicityPO);

    public List<Map<String,Object>> getCrdFdEntityDynamicsImgList(CrowdFundingPublicityImgPO CrowdFundingPublicityImgPO);

}
