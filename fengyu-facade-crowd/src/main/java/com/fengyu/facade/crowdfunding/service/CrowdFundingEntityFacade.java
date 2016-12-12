package com.fengyu.facade.crowdfunding.service;

import com.fengyu.common.core.base.service.BaseService;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdFundingAcctVO;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdFundingDetailVO;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdFundingEntityVO;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdFundingOrganiserVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/2.
 */
public interface CrowdFundingEntityFacade extends BaseService{
    public List<CrowdFundingEntityVO> getList4CrdFdBottomItem();
    public CrowdFundingEntityVO getCrowdFundingEntityInfo(CrowdFundingEntityVO crowdFundingEntityVO);

    public Integer newCrowdFundingEntity(CrowdFundingEntityVO crowdFundingEntityVO);
    public Integer editCrowdFundingEntity(CrowdFundingEntityVO crowdFundingEntityVO);

    public Integer editCrowdFundingEntityDetail(CrowdFundingDetailVO crowdFundingDetailVO);
    public CrowdFundingAcctVO getCrowdFundingEntityDetail(CrowdFundingDetailVO crowdFundingDetailVO);

    public Integer deleteCrowdFunding(Integer id);
    public Integer submitCrowdFunding(Integer id);


    public Integer newCrowdFundingOrganiser(CrowdFundingOrganiserVO crowdFundingOrganiserVO);
    public Integer editCrowdFundingOrganiser(CrowdFundingOrganiserVO crowdFundingOrganiserVO);
    public CrowdFundingOrganiserVO getCrowdFundingOrganiserInfo(CrowdFundingOrganiserVO crowdFundingOrganiserVO);

    public Integer newCrowdFundingAcct(CrowdFundingAcctVO crowdFundingAcctVO);
    public Integer editCrowdFundingAcct(CrowdFundingAcctVO crowdFundingAcctVO);
    public CrowdFundingAcctVO getCrowdFundingAcctInfo(CrowdFundingAcctVO crowdFundingAcctVO);



}
