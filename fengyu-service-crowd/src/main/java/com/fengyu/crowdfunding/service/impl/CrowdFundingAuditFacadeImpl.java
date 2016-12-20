package com.fengyu.crowdfunding.service.impl;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.core.base.service.impl.BaseServiceImpl;
import com.fengyu.crowdfunding.dao.CrowdFundingAuditDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingAuditPO;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdFundingAcctVO;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdFundingAuditVO;
import com.fengyu.facade.crowdfunding.service.CrowdFundingAuditFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/2.
 */
@Service(value = "crowdFundingAuditFacade")
@Transactional
public class CrowdFundingAuditFacadeImpl extends BaseServiceImpl implements CrowdFundingAuditFacade{
    @Autowired
    CrowdFundingAuditDao crowdFundingAuditDao;

    public List<CrowdFundingAuditVO> getList4CrdFdAudit(CrowdFundingAuditVO crowdFundingAuditVO)
    {
        List<CrowdFundingAuditVO> list=
        super.getObjectTransformer().defaulBatchtExcute(
                crowdFundingAuditDao.getList4CrdFdAudit(JSON.parseObject(JSON.toJSONString(crowdFundingAuditVO),Map.class))
                ,CrowdFundingAuditVO.class
        ) ;
        return list;
    }
    

}
