package com.fengyu.web.crowdfunding.controller;
import com.alibaba.dubbo.common.json.JSON;
import com.fengyu.common.exception.MapperSupport.CommonExceptionType;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.common.web.jersey.wrapper.ResponseWrapper;
import com.fengyu.facade.crowdfunding.exception.CrowdExceptionHandler;
import com.fengyu.facade.crowdfunding.exception.CrowdExceptionType;
import com.fengyu.facade.crowdfunding.service.CrowdFundingEntityFacade;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


@Component
@Path("/crowdFundingItem")
public class CrowdFundingItemController extends BaseController {

    @Autowired
    private CrowdFundingEntityFacade crowdFundingEntityFacade;

   /* @Autowired
    private UserFacade userFacade;
*/
    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 获取最底层众筹类目列表
     * @param
     * @return
    **/
    @POST
    @Path("getList4CrdFdBottomItem")
    public String getList4CrdFdBottomItem()
    {
        ResponseWrapper responseWrapper= null;
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"getList4CrdFdBottomItem",null);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND);
        }
        String jsonStr=nullParamOfJsonFilter(responseWrapper);
        /*try {
            throw  new CommonExceptionHandler(new Exception("1111"), CommonExceptionType.METHODNOTFOUND,"111","222");
        }catch ( CommonExceptionHandler e)
        {
            System.out.println(e.getMessage());
        }*/
        return jsonStr;
    }

}
