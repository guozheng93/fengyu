package com.fengyu.crowdfunding.service.impl;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.core.base.service.impl.BaseServiceImpl;
import com.fengyu.crowdfunding.dao.*;
import com.fengyu.crowdfunding.enums.CrowdFundingEnum;
import com.fengyu.facade.crowdfunding.entity.po.*;
import com.fengyu.facade.crowdfunding.entity.vo.*;
import com.fengyu.facade.crowdfunding.service.CrowdFundingEntityFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service(value = "crowdFundingEntityFacade")
@Transactional
public class CrowdFundingEntityFacadeImpl extends BaseServiceImpl implements CrowdFundingEntityFacade {

    @Autowired
    private CrowdFundingItemDao crowdFundingItemDao;

    @Autowired
    private CrowdFundingEntityDao crowdFundingEntityDao;
    @Autowired
    private CrowdFundingDao crowdFundingDao;

    @Autowired
    private CrowdFundingDetailDao crowdFundingDetailDao;

    @Autowired
    private CrowdFundingAcctDao crowdFundingAcctDao;
    @Autowired
    CrowdFundingOrganiserDao crowdFundingOrganiserDao;

    /**
     * @Author junz
     * @Date 2016/12/4 13:11
     * @Description 获取最底层的众筹类型类目
     * @Param
     * @Return CrowdFundingEntityVO
    **/
    @Override
    public List<CrowdFundingEntityVO> getList4CrdFdBottomItem() {
        List<CrowdFundingEntityVO> voList=null;
        try {
            List list=crowdFundingItemDao.getList4CrdFdBottomItem();
            voList=super.getObjectTransformer().defaulBatchtExcute(
                    list
                    ,CrowdFundingItemVO.class
            ) ;
        }catch (Exception e)
        {

        }

        return voList;
    }

    @Override
    public CrowdFundingEntityVO getCrowdFundingEntityInfo(CrowdFundingEntityVO crowdFundingEntityVO) {
        return null;
    }

    /**
 * @author junz
 * @date 2016/12/5 14:34
 * @description 众筹产品项目新增初始化几张表数据操作
 * crowdfunding
 *
 * @param
 * @return
**/@Override
    public Integer newCrowdFundingEntity(CrowdFundingEntityVO crowdFundingEntityVO) {
        CrowdFundingEntityPO crowdFundingEntityPO=new CrowdFundingEntityPO();
        CrowdFundingPO crowdFundingPO=new CrowdFundingPO();
        //对象vo向po赋值
        super.getObjectTransformer().defaultExcute(crowdFundingEntityVO,crowdFundingEntityPO);
        super.getObjectTransformer().defaultExcute(crowdFundingEntityVO,crowdFundingPO);

        //crowdFunding塞入其他字段
        crowdFundingPO.setPrjtRaiseType(CrowdFundingEnum.CrowdFundingRaiseType.CROWDFUNDINGRAISETYPE_MONEY.getCode());
        crowdFundingPO.setPrjtStatus(CrowdFundingEnum.CrowdFundingStatus.CROWDFUNDINGSTATUS_EDIT.getCode());
        //插入crowdFunding表
        crowdFundingDao.insert(crowdFundingPO);
        //插入crowdFundingentity 表
        crowdFundingEntityPO.setId(crowdFundingPO.getId());
        crowdFundingEntityDao.insert(crowdFundingEntityPO);

        //插入crowdfundingdetail 表
        CrowdFundingDetailPO crowdFundingDetailPO=new CrowdFundingDetailPO();
        crowdFundingDetailPO.setId(crowdFundingPO.getId());
        crowdFundingDetailDao.insert(crowdFundingDetailPO);

        return crowdFundingPO.getId();
    }

    @Override
    public Integer newCrowdFundingAcct(CrowdFundingAcctVO crowdFundingAcctVO) {
        CrowdFundingAcctPO crowdFundingAcctPO=new CrowdFundingAcctPO();
        super.getObjectTransformer().defaultExcute(crowdFundingAcctVO,crowdFundingAcctPO);
        return crowdFundingAcctDao.insert(crowdFundingAcctPO);
    }

    @Override
    public Integer newCrowdFundingOrganiser(CrowdFundingOrganiserVO crowdFundingOrganiserVO) {
        CrowdFundingOrganiserPO crowdFundingOrganiserPO=new CrowdFundingOrganiserPO();
        super.getObjectTransformer().defaultExcute(crowdFundingOrganiserVO,crowdFundingOrganiserPO);
        Integer result=crowdFundingOrganiserDao.insert(crowdFundingOrganiserPO);
        crowdFundingOrganiserVO.setId(crowdFundingOrganiserPO.getId());
        return crowdFundingOrganiserPO.getId();
    }

    @Override
    public Integer editCrowdFundingAcct(CrowdFundingAcctVO crowdFundingAcctVO) {
        CrowdFundingAcctPO crowdFundingAcctPO=new CrowdFundingAcctPO();
        super.getObjectTransformer().defaultExcute(crowdFundingAcctVO,crowdFundingAcctPO);
        return crowdFundingAcctDao.update(crowdFundingAcctPO);
    }

    @Override
    public CrowdFundingAcctVO getCrowdFundingAcctInfo(CrowdFundingAcctVO crowdFundingAcctVO) {
        Map map= JSON.parseObject(JSON.toJSONString(crowdFundingAcctVO), HashMap.class);
        return JSON.parseObject(JSON.toJSONString(crowdFundingAcctDao.select(map)),CrowdFundingAcctVO.class);
    }

    @Override
    public List<CrowdFundingAcctVO> getList4AcctByMap(Map crowdFundingAcctVO) {
        List<CrowdFundingAcctVO> voList=null;
        List list=crowdFundingAcctDao.getList4AcctByMap(crowdFundingAcctVO);
        voList=super.getObjectTransformer().defaulBatchtExcute(
                list
                ,CrowdFundingAcctVO.class
        ) ;

        return voList;
    }

    @Override
    public Integer editCrowdFundingOrganiser(CrowdFundingOrganiserVO crowdFundingOrganiserVO) {
        CrowdFundingOrganiserPO crowdFundingOrganiserPO=new CrowdFundingOrganiserPO();
        super.getObjectTransformer().defaultExcute(crowdFundingOrganiserVO,crowdFundingOrganiserPO);
        return crowdFundingOrganiserDao.update(crowdFundingOrganiserPO);
    }

    @Override
    public CrowdFundingOrganiserVO getCrowdFundingOrganiserInfo(CrowdFundingOrganiserVO crowdFundingOrganiserVO) {
        return null;
    }

    @Override
    public Integer editCrowdFundingEntity(CrowdFundingEntityVO crowdFundingEntityVO) {
        CrowdFundingEntityPO crowdFundingEntityPO=new CrowdFundingEntityPO();
        CrowdFundingPO crowdFundingPO=new CrowdFundingPO();
        super.getObjectTransformer().defaultExcute(crowdFundingEntityVO,crowdFundingEntityPO);
        super.getObjectTransformer().defaultExcute(crowdFundingEntityVO,crowdFundingPO);
        crowdFundingEntityDao.update(crowdFundingEntityPO);
        return crowdFundingDao.update(crowdFundingPO);
    }
    @Override
    public Integer editCrowdFundingEntityDetail(CrowdFundingDetailVO crowdFundingDetailVO) {
        CrowdFundingDetailPO crowdFundingDetailPO=new CrowdFundingDetailPO();
        super.getObjectTransformer().defaultExcute(crowdFundingDetailVO,crowdFundingDetailPO);
        return crowdFundingDetailDao.update(crowdFundingDetailPO);
    }

    @Override
    public CrowdFundingAcctVO getCrowdFundingEntityDetail(CrowdFundingDetailVO crowdFundingDetailVO) {
        return null;
    }

    @Override
    public Integer deleteCrowdFunding(Integer id) {
        return crowdFundingDao.delete(id);
    }
    @Override
    public Integer submitCrowdFunding(Integer id) {
        return crowdFundingDao.submitCrowdFunding(id);
    }
}
