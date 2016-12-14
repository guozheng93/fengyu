package com.fengyu.web.common.controller;


import com.fengyu.common.exception.MapperSupport.CommonExceptionType;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.common.web.jersey.wrapper.ResponseWrapper;
import com.fengyu.facade.crowdfunding.exception.CrowdExceptionHandler;
import com.fengyu.facade.other.common.service.BizDictionaryFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import java.lang.reflect.InvocationTargetException;

import java.util.Map;



@Component
@Path("/common/dic")
public class BizDictionaryController extends BaseController{
    @Autowired
    private BizDictionaryFacade bizDictionaryFacade;
   /**
    * @author junz
    * @date 2016/12/13 22:36
    * @description
    * @param
    * @return
   **/
    @POST
    @Path("getList4DicByMap")
    public String getList4DicByMap(String args) {
        Map dicParamMap= com.alibaba.fastjson.JSON.parseObject(args, Map.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(bizDictionaryFacade,"getList4DicByMap",dicParamMap);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

}













