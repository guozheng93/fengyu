package com.fengyu.web.crowdfunding.controller;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.CommonExceptionType;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.common.web.jersey.wrapper.ResponseWrapper;
import com.fengyu.facade.crowdfunding.entity.vo.*;
import com.fengyu.facade.crowdfunding.exception.CrowdExceptionHandler;
import com.fengyu.facade.crowdfunding.service.CrowdFundingEntityFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@Component
@Path("/crowdFundingEntity")
public class CrowdFundingEntityController extends BaseController {

    @Autowired
    private CrowdFundingEntityFacade crowdFundingEntityFacade;

   /* @Autowired
    private UserFacade userFacade;
*/
    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 新增众筹项目。各表初始化
     * @param
     * @return
    **/
    @POST
    @Path("newCrowdFundingEntity")
    public String newCrowdFundingEntity(String args)
    {
        CrowdFundingEntityVO crowdFundingEntityVO= JSON.parseObject(args, CrowdFundingEntityVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"newCrowdFundingEntity",crowdFundingEntityVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 新增众筹项目。各表初始化
     * @param
     * @return
     **/
    @POST
    @Path("getCrowdFundingEntityInfo")
    public String getCrowdFundingEntityInfo(String args)
    {
        CrowdFundingEntityVO crowdFundingEntityVO= JSON.parseObject(args, CrowdFundingEntityVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"getCrowdFundingEntityInfo",crowdFundingEntityVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 更新项目详情表
     * @param
     * @return
     **/
    @POST
    @Path("editCrowdFundingDetail")
    public String editCrowdFundingDetail(String args)
    {
        CrowdFundingDetailVO crowdFundingDetailVO= JSON.parseObject(args, CrowdFundingDetailVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"editCrowdFundingEntityDetail",crowdFundingDetailVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 更新产品众筹项目基本信息表
     * @param
     * @return
     **/
    @POST
    @Path("editCrowdFundingEntity")
    public String editCrowdFundingEntity(String args)
    {
        CrowdFundingEntityVO crowdFundingEntityVO= JSON.parseObject(args, CrowdFundingEntityVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"editCrowdFundingEntity",crowdFundingEntityVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 更新产品众筹项目基本信息表
     * @param
     * @return
     **/
    @POST
    @Path("deleteCrowdFunding")
    public String deleteCrowdFunding(String args)
    {
        CrowdFundingVO crowdFundingVO= JSON.parseObject(args, CrowdFundingVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"deleteCrowdFunding",crowdFundingVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }



    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 新增发起人信息
     * @param
     * @return
     **/
    @POST
    @Path("newCrowdFundingOrganiser")
    public String newCrowdFundingOrganiser(String args)
    {
        CrowdFundingOrganiserVO crowdFundingOrganiserVO= JSON.parseObject(args, CrowdFundingOrganiserVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"newCrowdFundingOrganiser",crowdFundingOrganiserVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }
    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 修改发起人信息
     * @param
     * @return
     **/
    @POST
    @Path("editCrowdFundingOrganiser")
    public String editCrowdFundingOrganiser(String args)
    {
        CrowdFundingOrganiserVO crowdFundingOrganiserVO= JSON.parseObject(args, CrowdFundingOrganiserVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"editCrowdFundingOrganiser",crowdFundingOrganiserVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 更新产品众筹项目收款信息表
     * @param
     * @return
     **/
    @POST
    @Path("editCrowdFundingAcct")
    public String editCrowdFundingAcct(String args)
    {
        CrowdFundingAcctVO crowdFundingAcctVO= JSON.parseObject(args, CrowdFundingAcctVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"editCrowdFundingAcct",crowdFundingAcctVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }
    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 更新产品众筹项目收款信息表
     * @param
     * @return
     **/
    @POST
    @Path("newCrowdFundingAcct")
    public String newCrowdFundingAcct(String args)
    {
        CrowdFundingAcctVO crowdFundingAcctVO= JSON.parseObject(args, CrowdFundingAcctVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"newCrowdFundingAcct",crowdFundingAcctVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    @POST
    @Path("getList4AcctByMap")
    public String getList4AcctByMap(String args) {
        Map acctParamMap= com.alibaba.fastjson.JSON.parseObject(args, Map.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"getList4AcctByMap",acctParamMap);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    @POST
    @Path("getCrowdFundingAcctInfo")
    public String getCrowdFundingAcctInfo(String args) {
        CrowdFundingAcctVO crowdFundingAcctVO= JSON.parseObject(args, CrowdFundingAcctVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"getCrowdFundingAcctInfo",crowdFundingAcctVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

}
