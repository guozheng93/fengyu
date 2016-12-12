package com.fengyu.facade.crowdfunding.service;

import com.fengyu.common.core.base.service.BaseService;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdFundingRepayVO;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdfundingItemPropValueVO;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdfundingItemPropsVO;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/2.
 */
public interface CrowdFundingRepayFacade extends BaseService{
    public CrowdFundingRepayVO getCrowdFundingRepayInfo(CrowdFundingRepayVO crowdFundingRepayVO);

    public List<CrowdFundingRepayVO> getList4CrowdFundingRepay(Map map);

    public CrowdfundingItemPropsVO getCrowdfundingItemPropsInfo(CrowdfundingItemPropsVO crowdfundingItemPropsVO);
    public List<CrowdfundingItemPropsVO> getList4CrowdfundingItemProps(Map map);

    public CrowdfundingItemPropValueVO getCrowdfundingItemPropValueInfo(CrowdfundingItemPropValueVO crowdfundingItemPropValueVO);
    public List<CrowdfundingItemPropValueVO> getList4CrowdfundingItemPropValueByItmPropId(Integer itmPropId);

    public Integer newCrowdFundingRepay(CrowdFundingRepayVO crowdFundingRepayVO);
    public Integer newCrowdfundingItemProps(CrowdfundingItemPropsVO crowdfundingItemPropsVO);
    public Integer newCrowdfundingItemPropValue(CrowdfundingItemPropValueVO crowdfundingItemPropValueVO);

    public Integer newCrowdfundingItemPropsBatch(List<CrowdfundingItemPropsVO> crowdfundingItemPropsVOList);

    public Integer editCrowdFundingRepay(CrowdFundingRepayVO crowdFundingRepayVO);

    public Integer deleteCrowdFundingRepay(CrowdFundingRepayVO crowdFundingRepayVO);
    public Integer deleteCrowdfundingItemProps(Integer id);
    public Integer deleteCrowdfundingItemPropValue(Integer id);






}
