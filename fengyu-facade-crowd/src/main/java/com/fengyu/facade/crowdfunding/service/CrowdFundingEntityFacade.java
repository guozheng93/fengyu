package com.fengyu.facade.crowdfunding.service;

import com.fengyu.common.core.base.service.BaseService;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingFocusPO;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingPraisePO;
import com.fengyu.facade.crowdfunding.entity.vo.*;

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
    public CrowdFundingDetailVO getCrowdFundingEntityDetail(CrowdFundingDetailVO crowdFundingDetailVO);
    public List<CrowdFundingEntityVO> getPageList4CrdFdEntity(CrowdFundingEntityVO crowdFundingEntityVO);

    public Integer deleteCrowdFunding(Integer id);
    public Integer submitCrowdFunding(Integer id);


    public Integer newCrowdFundingOrganiser(CrowdFundingOrganiserVO crowdFundingOrganiserVO);
    public Integer editCrowdFundingOrganiser(CrowdFundingOrganiserVO crowdFundingOrganiserVO);
    public CrowdFundingOrganiserVO getCrowdFundingOrganiserInfo(CrowdFundingOrganiserVO crowdFundingOrganiserVO);

    public Integer newCrowdFundingAcct(CrowdFundingAcctVO crowdFundingAcctVO);
    public Integer editCrowdFundingAcct(CrowdFundingAcctVO crowdFundingAcctVO);
    public CrowdFundingAcctVO getCrowdFundingAcctInfo(CrowdFundingAcctVO crowdFundingAcctVO);
    public List<CrowdFundingAcctVO> getList4AcctByMap(Map crowdFundingAcctVO);
    public Integer submitPrjt(CrowdFundingEntityVO crowdFundingEntityVO);

    public Integer getTotalPraise(CrowdFundingPraiseVO crowdFundingPraiseVO);
    public Integer getTotalFocus(CrowdFundingFocusVO crowdFundingFocusVO);

    public List<CrowdFundingPraiseVO> getPraiseList(CrowdFundingPraiseVO crowdFundingPraiseVO);
    public List<CrowdFundingFocusVO> getFocusList(CrowdFundingFocusVO crowdFundingFocusVO);

    public Integer newTotalPraise(CrowdFundingPraiseVO crowdFundingPraiseVO);
    public Integer newTotalFocus(CrowdFundingFocusVO crowdFundingFocusVO);

    public List<CrowdFundingPublicityVO> getPageList4CrdFdEntityDynamics(CrowdFundingPublicityVO crowdFundingPublicityVO);
    public List<CrowdFundingPublicityImgVO> getCrdFdEntityDynamicsImgList(CrowdFundingPublicityImgVO crowdFundingPublicityImgVO);

}
