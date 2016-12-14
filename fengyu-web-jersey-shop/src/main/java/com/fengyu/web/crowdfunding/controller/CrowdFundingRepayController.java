package com.fengyu.web.crowdfunding.controller;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.CommonExceptionType;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.common.web.jersey.wrapper.ResponseWrapper;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdFundingRepayVO;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdfundingItemPropValueVO;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdfundingItemPropsVO;
import com.fengyu.facade.crowdfunding.exception.CrowdExceptionHandler;
import com.fengyu.facade.crowdfunding.service.CrowdFundingRepayFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


@Component
@Path("/crowdFundingRepay")
public class CrowdFundingRepayController extends BaseController {

    @Autowired
    private CrowdFundingRepayFacade crowdFundingRepayFacade;

   /* @Autowired
    private UserFacade userFacade;
*/
    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 获取回报基本信息
     * @param
     * @return
    **/
    @POST
    @Path("getCrowdFundingRepayInfo")
    public String getCrowdFundingRepayInfo(String args)
    {
        CrowdFundingRepayVO crowdFundingRepayVO= JSON.parseObject(args, CrowdFundingRepayVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"getCrowdFundingRepayInfo",crowdFundingRepayVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 获取回报基本信息
     * @param
     * @return
     **/
    @POST
    @Path("getList4CrowdFundingRepay")
    public String getList4CrowdFundingRepay(String args)
    {
        Map crowdFundingRepayVO= JSON.parseObject(args, Map.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"getList4CrowdFundingRepay",crowdFundingRepayVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 获取回报属性 特征量
     * @param
     * @return
     **/
    @POST
    @Path("getCrowdfundingItemPropsInfo")
    public String getCrowdfundingItemPropsInfo  (String args)
    {
        CrowdfundingItemPropsVO crowdfundingItemPropsVO= JSON.parseObject(args, CrowdfundingItemPropsVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"getCrowdfundingItemPropsInfo",crowdfundingItemPropsVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }
    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 获取回报属性 特征量 列表
     * @param
     * @return
     **/
    @POST
    @Path("getList4CrowdfundingItemProps")
    public String getList4CrowdfundingItemProps  (String args)
    {
        CrowdfundingItemPropsVO crowdfundingItemPropsVO= JSON.parseObject(args, CrowdfundingItemPropsVO.class);
        Map crowdfundingItemPropsMap= JSON.parseObject(args, Map.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"getList4CrowdfundingItemProps",crowdfundingItemPropsMap);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 获取项目回报属性值，特征值
     * @param
     * @return
     **/
    @POST
    @Path("getCrowdfundingItemPropValueInfo")
    public String getCrowdfundingItemPropValueInfo(String args)
    {
        CrowdfundingItemPropValueVO crowdfundingItemPropValueVO= JSON.parseObject(args, CrowdfundingItemPropValueVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"getCrowdfundingItemPropValueInfo",crowdfundingItemPropValueVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 获取项目回报属性值，特征值列表
     * @param
     * @return
     **/
    @POST
    @Path("getList4CrowdfundingItemPropValueByItmPropId")
    public String getList4CrowdfundingItemPropValueByItmPropId(String args)
    {
        Map crowdfundingItemPropValueVO= JSON.parseObject(args, Map.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"getList4CrowdfundingItemPropValueByItmPropId",crowdfundingItemPropValueVO.get("propId"));
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 新增回报
     * @param
     * @return
     **/
    @POST
    @Path("newCrowdFundingRepay")
    public String newCrowdFundingRepay(String args)
    {
        CrowdFundingRepayVO crowdFundingRepayVO= JSON.parseObject(args, CrowdFundingRepayVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"newCrowdFundingRepay",crowdFundingRepayVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 新增回报属性，特征值
     * @param
     * @return
     **/
    @POST
    @Path("newCrowdfundingItemPropValue")
    public String newCrowdfundingItemPropValue(String args)
    {
        CrowdfundingItemPropValueVO crowdfundingItemPropValueVO= JSON.parseObject(args, CrowdfundingItemPropValueVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"newCrowdfundingItemPropValue",crowdfundingItemPropValueVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 新增回报属性，特征量
     * @param
     * @return
     **/
    @POST
    @Path("newCrowdfundingItemProps")
    public String newCrowdfundingItemProps(String args)
    {
        CrowdfundingItemPropsVO crowdfundingItemPropsVO= JSON.parseObject(args, CrowdfundingItemPropsVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"newCrowdfundingItemProps",crowdfundingItemPropsVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }
    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 批量新增回报属性，特征量 特征值
     * 简化逻辑，容易造成冗余数据。可使用日终批量处理，来处理数据
     * @param
     * @return
     **/
    @POST
    @Path("newCrowdfundingItemPropsBatch")
    public String newCrowdfundingItemPropsBatch(String args)
    {
        List<CrowdfundingItemPropsVO> crowdfundingItemPropsVO= JSON.parseObject(args, List.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"newCrowdfundingItemPropsBatch",crowdfundingItemPropsVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 更新回报属性
     * @param
     * @return
     **/
    @POST
    @Path("editCrowdFundingRepay")
    public String editCrowdFundingRepay(String args)
    {
        CrowdFundingRepayVO crowdFundingRepayVO= JSON.parseObject(args, CrowdFundingRepayVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"editCrowdFundingRepay",crowdFundingRepayVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 删除回报
     * @param
     * @return
     **/
    @POST
    @Path("deleteCrowdFundingRepay")
    public String deleteCrowdFundingRepay(String args)
    {
        CrowdFundingRepayVO crowdFundingRepayVO = JSON.parseObject(args, CrowdFundingRepayVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"deleteCrowdFundingRepay",crowdFundingRepayVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 获取最底层众筹类目列表
     * @param
     * @return
     **/
    @POST
    @Path("deleteCrowdfundingItemProps")
    public String deleteCrowdfundingItemProps(String args)
    {
        Map map = JSON.parseObject(args, Map.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"deleteCrowdfundingItemProps",Integer.parseInt(map.get("id").toString()));
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 获取最底层众筹类目列表
     * @param
     * @return
     **/
    @POST
    @Path("deleteCrowdfundingItemPropValue")
    public String deleteCrowdfundingItemPropValue(String args)
    {
        Map map = JSON.parseObject(args, Map.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingRepayFacade,"deleteCrowdfundingItemPropValue",Integer.parseInt(map.get("id").toString()));
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

}
