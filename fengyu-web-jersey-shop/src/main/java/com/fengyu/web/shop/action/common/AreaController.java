package com.fengyu.web.shop.action.common;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.facade.other.area.service.AreaFacade;
import com.fengyu.facade.other.verifycode.entity.po.VerifyCodePO;
import com.fengyu.facade.other.verifycode.service.VerifyCodeFacade;
import com.fengyu.web.shop.util.API.Phone.AliMsgApi;
import com.fengyu.web.shop.util.API.Phone.enums.PhoneCode;
import com.fengyu.web.shop.util.token.ResponseUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guoz
 * @version V1.0
 * @date 2016/12/17
 */
@Component
@Path("/common/area")
public class AreaController extends BaseController{

    private static final Logger logger = LogManager.getLogger(AreaController.class);

    @Autowired
    private AreaFacade areaFacade;

    @POST
    @Path("list")
    public String list(String args)
    {
        try {
            Map<String, Object> map = JSON.parseObject(args, Map.class);
            Integer currentPage = Integer.parseInt(map.get("currentPage").toString());
            Integer numPerPage = Integer.parseInt(map.get("numPerPage").toString());
            PageParam pageParam = new PageParam(currentPage,numPerPage);
            PageBean pageBean = areaFacade.listPage(pageParam,map);
            return ResponseUtil.success(pageBean);
        } catch (Exception e) {
            logger.error(e);
            return ResponseUtil.unKonwException();
        }
    }
}
