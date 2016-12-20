package com.fengyu.web.order.controller;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.CommonExceptionType;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.common.web.jersey.wrapper.ResponseWrapper;
import com.fengyu.facade.crowdfunding.entity.vo.CrowdFundingAcctVO;
import com.fengyu.facade.crowdfunding.exception.CrowdExceptionHandler;
import com.fengyu.facade.crowdfunding.service.CrowdFundingEntityFacade;
import com.fengyu.facade.order.entity.vo.OrderVO;
import com.fengyu.facade.order.service.OrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@Component
@Path("/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderFacade orderFacade;
    @Autowired
    private CrowdFundingEntityFacade crowdFundingEntityFacade;

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 获取最底层众筹类目列表
     * @param
     * @return
    **/
    @POST
    @Path("getPageList4CrdFdEntityOrder")
    public String getPageList4CrdFdEntityOrder(String args)
    {
        OrderVO orderVO= JSON.parseObject(args, OrderVO.class);
        ResponseWrapper responseWrapper= null;
        try {
            responseWrapper = doServiceAndResponse(orderFacade,"getPageList4Order",orderVO);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND);
        }
        String jsonStr=nullParamOfJsonFilter(responseWrapper);

        return jsonStr;
    }

}
