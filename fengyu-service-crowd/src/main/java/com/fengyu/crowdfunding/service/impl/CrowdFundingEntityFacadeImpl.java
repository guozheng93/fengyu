package com.fengyu.crowdfunding.service.impl;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.core.base.service.impl.BaseServiceImpl;
import com.fengyu.common.utils.BeanUtils;
import com.fengyu.crowdfunding.dao.*;
import com.fengyu.facade.crowdfunding.enums.CrowdFundingEnum;
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

    @Autowired
    CrowdFundingFocusDao crowdFundingFocusDao;

    @Autowired
    CrowdFundingPraiseDao crowdFundingPraiseDao;

    @Autowired
    CrowdFundingPublicityDao crowdFundingPublicityDao;

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
        Map map=JSON.parseObject(JSON.toJSONString(crowdFundingEntityVO), HashMap.class);
        Map returnMap=crowdFundingEntityDao.select(map);
        returnMap= BeanUtils.transDataMap2BeanMap4FiledName(returnMap);
        return JSON.parseObject(JSON.toJSONString(returnMap),CrowdFundingEntityVO.class);
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
        crowdFundingAcctDao.delete4Map(crowdFundingAcctPO);
        crowdFundingAcctDao.insert(crowdFundingAcctPO);
        Integer num=crowdFundingAcctDao.insert2Map(crowdFundingAcctPO);
        return num;
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
        crowdFundingAcctDao.delete4Map(crowdFundingAcctPO);
        crowdFundingAcctDao.insert2Map(crowdFundingAcctPO);
        crowdFundingAcctDao.update(crowdFundingAcctPO);
        return crowdFundingAcctPO.getId();
    }

    @Override
    public CrowdFundingAcctVO getCrowdFundingAcctInfo(CrowdFundingAcctVO crowdFundingAcctVO) {
        Map map= JSON.parseObject(JSON.toJSONString(crowdFundingAcctVO), HashMap.class);
        Map returnMap=crowdFundingAcctDao.select(map);
        returnMap=BeanUtils.transDataMap2BeanMap4FiledName(returnMap);
        return JSON.parseObject(JSON.toJSONString(returnMap),CrowdFundingAcctVO.class);
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
    public Integer submitPrjt(CrowdFundingEntityVO crowdFundingEntityVO) {
        CrowdFundingEntityPO crowdFundingEntityPO=new CrowdFundingEntityPO();
        super.getObjectTransformer().defaultExcute(crowdFundingEntityVO,crowdFundingEntityPO);
        crowdFundingEntityPO.setPrjtStatus(CrowdFundingEnum.CrowdFundingStatus.CROWDFUNDINGSTATUS_SUBMIT.getCode());
        return crowdFundingDao.submitCrowdFunding(crowdFundingEntityPO.getId());
    }

    @Override
    public Integer getTotalPraise(CrowdFundingPraiseVO crowdFundingPraiseVO) {
        CrowdFundingPraisePO crowdFundingPraisePO=new CrowdFundingPraisePO();
        super.getObjectTransformer().defaultExcute(crowdFundingPraiseVO,crowdFundingPraisePO);
        return crowdFundingPraiseDao.selectTotal(crowdFundingPraisePO);
    }

    @Override
    public Integer getTotalFocus(CrowdFundingFocusVO crowdFundingFocusVO) {
        CrowdFundingFocusPO crowdFundingFocusPO=new CrowdFundingFocusPO();
        super.getObjectTransformer().defaultExcute(crowdFundingFocusVO,crowdFundingFocusPO);
        return crowdFundingFocusDao.selectTotal(crowdFundingFocusPO);
    }

    @Override
    public List<CrowdFundingPraiseVO> getPraiseList(CrowdFundingPraiseVO crowdFundingPraiseVO) {
        List<CrowdFundingPraiseVO> voList=null;
        CrowdFundingPraisePO crowdFundingPraisePO=JSON.parseObject(JSON.toJSONString(crowdFundingPraiseVO),CrowdFundingPraisePO.class);
        List list=crowdFundingPraiseDao.getPraiseList(crowdFundingPraisePO);
        voList=super.getObjectTransformer().defaulBatchtExcute(
                list
                ,CrowdFundingPraiseVO.class
        ) ;

        return voList;
    }

    @Override
    public List<CrowdFundingFocusVO> getFocusList(CrowdFundingFocusVO crowdFundingFocusVO) {
        List<CrowdFundingFocusVO> voList=null;
        CrowdFundingFocusPO crowdFundingFocusPO=JSON.parseObject(JSON.toJSONString(crowdFundingFocusVO),CrowdFundingFocusPO.class);
        List list=crowdFundingFocusDao.getFocusList(crowdFundingFocusPO);
        voList=super.getObjectTransformer().defaulBatchtExcute(
                list
                ,CrowdFundingFocusVO.class
        ) ;

        return voList;
    }

    @Override
    public Integer newTotalPraise(CrowdFundingPraiseVO crowdFundingPraiseVO) {
        CrowdFundingPraisePO crowdFundingPraisePO=new CrowdFundingPraisePO();
        super.getObjectTransformer().defaultExcute(crowdFundingPraiseVO,crowdFundingPraisePO);
        return crowdFundingPraiseDao.insert(crowdFundingPraisePO);
    }

    @Override
    public Integer newTotalFocus(CrowdFundingFocusVO crowdFundingFocusVO) {
        CrowdFundingFocusPO crowdFundingFocusPO=new CrowdFundingFocusPO();
        super.getObjectTransformer().defaultExcute(crowdFundingFocusVO,crowdFundingFocusPO);
        return crowdFundingFocusDao.insert(crowdFundingFocusPO);
    }

    @Override
    public Integer editCrowdFundingOrganiser(CrowdFundingOrganiserVO crowdFundingOrganiserVO) {
        CrowdFundingOrganiserPO crowdFundingOrganiserPO=new CrowdFundingOrganiserPO();
        super.getObjectTransformer().defaultExcute(crowdFundingOrganiserVO,crowdFundingOrganiserPO);
        return crowdFundingOrganiserDao.update(crowdFundingOrganiserPO);
    }

    @Override
    public CrowdFundingOrganiserVO getCrowdFundingOrganiserInfo(CrowdFundingOrganiserVO crowdFundingOrganiserVO) {
        Map map=JSON.parseObject(JSON.toJSONString(crowdFundingOrganiserVO), HashMap.class);
        Map returnMap=crowdFundingOrganiserDao.select(map);
        returnMap= BeanUtils.transDataMap2BeanMap4FiledName(returnMap);
        return JSON.parseObject(JSON.toJSONString(returnMap),CrowdFundingOrganiserVO.class);
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
    public CrowdFundingDetailVO getCrowdFundingEntityDetail(CrowdFundingDetailVO crowdFundingDetailVO) {
        Map map=JSON.parseObject(JSON.toJSONString(crowdFundingDetailVO), HashMap.class);
        Map returnMap=crowdFundingDetailDao.select(map);
        returnMap= BeanUtils.transDataMap2BeanMap4FiledName(returnMap);
        return JSON.parseObject(JSON.toJSONString(returnMap),CrowdFundingDetailVO.class);
    }

    @Override
    public Integer deleteCrowdFunding(Integer id) {
        return crowdFundingDao.delete(id);
    }
    @Override
    public Integer submitCrowdFunding(Integer id) {
        return crowdFundingDao.submitCrowdFunding(id);
    }

    @Override
    public List<CrowdFundingPublicityVO> getPageList4CrdFdEntityDynamics(CrowdFundingPublicityVO crowdFundingPublicityVO) {
        List<CrowdFundingPublicityVO> voList=null;
        CrowdFundingPublicityPO crowdFundingPublicityPO=JSON.parseObject(JSON.toJSONString(crowdFundingPublicityVO),CrowdFundingPublicityPO.class);
        List list=crowdFundingPublicityDao.getPageList4CrdFdEntityDynamics(crowdFundingPublicityPO);
        voList=super.getObjectTransformer().defaulBatchtExcute(
                list
                ,CrowdFundingPublicityVO.class
        ) ;
        return voList;
    }

    @Override
    public List<CrowdFundingPublicityImgVO> getCrdFdEntityDynamicsImgList(CrowdFundingPublicityImgVO crowdFundingPublicityImgVO) {
        List<CrowdFundingPublicityImgVO> voList=null;
        CrowdFundingPublicityImgPO crowdFundingPublicityImgPO=JSON.parseObject(JSON.toJSONString(crowdFundingPublicityImgVO),CrowdFundingPublicityImgPO.class);
        List list=crowdFundingPublicityDao.getCrdFdEntityDynamicsImgList(crowdFundingPublicityImgPO);
        voList=super.getObjectTransformer().defaulBatchtExcute(
                list
                ,CrowdFundingPublicityImgVO.class
        ) ;
        return voList;
    }

    @Override
    public List<CrowdFundingEntityVO> getPageList4CrdFdEntity(CrowdFundingEntityVO crowdFundingEntityVO) {
        List<CrowdFundingEntityVO> voList=null;
        Map map=JSON.parseObject(JSON.toJSONString(crowdFundingEntityVO),Map.class);
        List list=crowdFundingEntityDao.getPageList4CrdFdEntity(map);
        voList=super.getObjectTransformer().defaulBatchtExcute(
                list
                ,CrowdFundingPublicityImgVO.class
        ) ;
        return null;
    }
}
