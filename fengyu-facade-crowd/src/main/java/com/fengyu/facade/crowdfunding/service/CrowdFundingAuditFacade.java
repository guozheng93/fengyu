package com.fengyu.facade.crowdfunding.service;

import com.fengyu.common.core.base.service.BaseService;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingAuditPO;
import com.fengyu.facade.crowdfunding.entity.vo.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/2.
 */
public interface CrowdFundingAuditFacade extends BaseService{
    public List<CrowdFundingAuditVO> getList4CrdFdAudit(CrowdFundingAuditVO crowdFundingAuditVO);


}
