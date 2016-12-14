package com.fengyu.crowdfunding.service.impl;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.core.base.service.impl.BaseServiceImpl;
import com.fengyu.common.utils.BeanUtils;

import com.fengyu.crowdfunding.dao.CrowdFundingItemPropsDao;
import com.fengyu.crowdfunding.dao.CrowdFundingRepayDao;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingRepayPO;
import com.fengyu.facade.crowdfunding.entity.po.CrowdfundingItemPropValuePO;
import com.fengyu.facade.crowdfunding.entity.po.CrowdfundingItemPropsPO;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdFundingRepayVO;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdfundingItemPropValueVO;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdfundingItemPropsVO;
import com.fengyu.facade.crowdfunding.service.CrowdFundingRepayFacade;
import com.fengyu.crowdfunding.dao.CrowdFundingItemPropValueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service(value = "crowdFundingRepayFacade")
@Transactional
public class CrowdFundingRepayFacadeImpl extends BaseServiceImpl implements CrowdFundingRepayFacade {

    @Autowired
    private CrowdFundingRepayDao crowdFundingRepayDao;

    @Autowired
    private CrowdFundingItemPropsDao crowdFundingItemPropsDao;

    @Autowired
    private CrowdFundingItemPropValueDao crowdFundingItemPropValueDao;


    public CrowdFundingRepayVO getCrowdFundingRepayInfo(CrowdFundingRepayVO crowdFundingRepayVO) {
        Map map=JSON.parseObject(JSON.toJSONString(crowdFundingRepayVO), HashMap.class);
        Map returnMap=crowdFundingRepayDao.select(map);
        returnMap= BeanUtils.transDataMap2BeanMap4FiledName(returnMap);
        return JSON.parseObject(JSON.toJSONString(returnMap),CrowdFundingRepayVO.class);
    }
    @Override
    public List<CrowdFundingRepayVO> getList4CrowdFundingRepay(Map map) {
        List<CrowdFundingRepayVO> voList=null;
        List list=crowdFundingRepayDao.getList4CrowdFundingRepay22(map);
        voList=super.getObjectTransformer().defaulBatchtExcute(
                list
                ,CrowdFundingRepayVO.class);


        return voList;
    }
    public CrowdfundingItemPropsVO getCrowdfundingItemPropsInfo(CrowdfundingItemPropsVO crowdfundingItemPropsVO) {
        Map map=JSON.parseObject(JSON.toJSONString(crowdfundingItemPropsVO), HashMap.class);
        return JSON.parseObject(JSON.toJSONString(crowdFundingItemPropsDao.select(map)),CrowdfundingItemPropsVO.class);
    }

    public List<CrowdfundingItemPropsVO> getList4CrowdfundingItemProps(Map map) {
        List<CrowdfundingItemPropsVO> voList=null;
        List list=crowdFundingItemPropsDao.getList4CrowdfundingItemProps11(map);
        voList=super.getObjectTransformer().defaulBatchtExcute(
                list
                ,CrowdfundingItemPropsVO.class
        ) ;


        return voList;
    }

    public CrowdfundingItemPropValueVO getCrowdfundingItemPropValueInfo(CrowdfundingItemPropValueVO crowdfundingItemPropsVO) {
        Map map=JSON.parseObject(JSON.toJSONString(crowdfundingItemPropsVO), HashMap.class);
        return JSON.parseObject(JSON.toJSONString(crowdFundingRepayDao.select(map)),CrowdfundingItemPropValueVO.class);
    }

    public List<CrowdfundingItemPropValueVO> getList4CrowdfundingItemPropValueByItmPropId(Integer itmPropId) {
        List<CrowdfundingItemPropValueVO> voList=null;
        List list=crowdFundingItemPropValueDao.getList4CrowdfundingItemPropValueByItmPropId(itmPropId);
        voList=super.getObjectTransformer().defaulBatchtExcute(
                list
                ,CrowdfundingItemPropValueVO.class
        ) ;


        return voList;
    }

    public Integer newCrowdFundingRepay(CrowdFundingRepayVO crowdFundingRepayVO) {
        CrowdFundingRepayPO crowdFundingRepayPO=new CrowdFundingRepayPO();
        super.getObjectTransformer().defaultExcute(crowdFundingRepayVO,crowdFundingRepayPO);
        Integer id=crowdFundingRepayDao.insert(crowdFundingRepayPO);
        return id;
    }

    public Integer newCrowdfundingItemProps(CrowdfundingItemPropsVO crowdfundingItemPropsVO) {
        CrowdfundingItemPropsPO crowdfundingItemPropsPO=new CrowdfundingItemPropsPO();
        super.getObjectTransformer().defaultExcute(crowdfundingItemPropsVO,crowdfundingItemPropsPO);
        Integer id=crowdFundingItemPropsDao.insert(crowdfundingItemPropsPO);
        return id;
    }

    /**
     * @author junz
     * @date 2016/12/11 20:02
     * @description 批量插入特征量以及特征值
     * @param
     * @return
    **/
    public Integer newCrowdfundingItemPropsBatch(List<CrowdfundingItemPropsVO> crowdfundingItemPropsVOs) {
        Integer num=0;
        int forSize=crowdfundingItemPropsVOs.size();
        for (int i=0;i<forSize;i++)
        {
            CrowdfundingItemPropsVO  crowdfundingItemPropsVO=JSON.parseObject(JSON.toJSONString(crowdfundingItemPropsVOs.get(i))
                    , CrowdfundingItemPropsVO.class);
            CrowdfundingItemPropsPO crowdfundingItemPropsPO=new CrowdfundingItemPropsPO();

            super.getObjectTransformer().defaultExcute(crowdfundingItemPropsVO,crowdfundingItemPropsPO);
            //首先将该项目下面该repay下面所有的map  itemprop 映射删掉
            if(i==0)
                crowdFundingItemPropsDao.physicsDelete4Map(crowdfundingItemPropsPO);

            //插入itemprop
            Integer temp=crowdFundingItemPropsDao.insert(crowdfundingItemPropsPO);
            num=num+temp;
            //插入itemprop
            crowdFundingItemPropsDao.insert4Map(crowdfundingItemPropsPO);


            //开始处理Prop value
            List<CrowdfundingItemPropValueVO> crowdfundingItemPropValueVOs=crowdfundingItemPropsVO.getPropValues();
            for (int j = 0; j < crowdfundingItemPropValueVOs.size(); j++) {
                CrowdfundingItemPropValuePO crowdfundingItemPropValuePO=new CrowdfundingItemPropValuePO();
                CrowdfundingItemPropValueVO  crowdfundingItemPropValueVO=crowdfundingItemPropValueVOs.get(j);
                crowdfundingItemPropValueVO.setPropId(crowdfundingItemPropsPO.getId());
                crowdfundingItemPropValuePO=JSON.parseObject(JSON.toJSONString(crowdfundingItemPropValueVO),CrowdfundingItemPropValuePO.class);
                //首先将该项目下面该repay下面所有的map  itempropvalue删掉
                if(i==0&&j==0)
                    crowdFundingItemPropValueDao.physicsDelete(crowdfundingItemPropValuePO);
                //插入新的propvalue
                num=num+crowdFundingItemPropValueDao.insert(crowdfundingItemPropValuePO);
            }
            System.out.println(i);
        }

        return num;
    }

    public Integer newCrowdfundingItemPropValue(CrowdfundingItemPropValueVO crowdfundingItemPropValueVO) {
        CrowdfundingItemPropValuePO crowdfundingItemPropValuePO=new CrowdfundingItemPropValuePO();
        super.getObjectTransformer().defaultExcute(crowdfundingItemPropValueVO,crowdfundingItemPropValuePO);
        Integer id=crowdFundingItemPropValueDao.insert(crowdfundingItemPropValuePO);
        return id;
    }

    public Integer editCrowdFundingRepay(CrowdFundingRepayVO crowdFundingRepayVO) {
        CrowdFundingRepayPO crowdFundingRepayPO=new CrowdFundingRepayPO();
        super.getObjectTransformer().defaultExcute(crowdFundingRepayVO,crowdFundingRepayPO);
        Integer num=crowdFundingRepayDao.update(crowdFundingRepayPO);
        return num;
    }



    public Integer deleteCrowdFundingRepay(CrowdFundingRepayVO crowdFundingRepayVO) {
        CrowdFundingRepayPO crowdFundingRepayPO=new CrowdFundingRepayPO();
        super.getObjectTransformer().defaultExcute(crowdFundingRepayVO,crowdFundingRepayPO);
        return crowdFundingRepayDao.deleteByMap(crowdFundingRepayPO);
    }

    public Integer deleteCrowdfundingItemProps(Integer id) {
        return crowdFundingItemPropsDao.delete(id);
    }

    public Integer deleteCrowdfundingItemPropValue(Integer id) {
        return crowdFundingItemPropValueDao.delete(id);
    }

    public static void main(String[] args) {


    }
}
