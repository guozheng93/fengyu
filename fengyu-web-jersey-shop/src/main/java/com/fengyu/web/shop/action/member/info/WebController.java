package com.fengyu.web.shop.action.member.info;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.facade.user.address.entity.po.AddressPO;
import com.fengyu.facade.user.address.service.AddressFacade;
import com.fengyu.facade.user.info.entity.po.InfoPO;
import com.fengyu.facade.user.info.service.InfoFacade;
import com.fengyu.web.shop.util.token.ResponseUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;


@Component
@Path("/member/info")
public class WebController extends BaseController {

    private static final Logger logger = LogManager.getLogger(WebController.class);

    @Autowired
    private InfoFacade infoFacade;

    @POST
    @Path("get")
    public String get()
    {
        try {
            InfoPO po = infoFacade.getById(getUserId());
            return  ResponseUtil.success(po);
        } catch (Exception e) {
            logger.error(e);
            return ResponseUtil.unKonwException();
        }
    }

    @POST
    @Path("list")
    public String list(String args)
    {
        try {
            Map<String, Object> map = JSON.parseObject(args, Map.class);
            Integer currentPage = Integer.parseInt(map.get("currentPage").toString());
            Integer numPerPage = Integer.parseInt(map.get("numPerPage").toString());
            PageParam pageParam = new PageParam(currentPage,numPerPage);
            PageBean pageBean = infoFacade.listPage(pageParam,map);
            return ResponseUtil.success(pageBean);
        } catch (Exception e) {
            logger.error(e);
            return ResponseUtil.unKonwException();
        }
    }

    @POST
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(String args)
    {
        try {
            InfoPO infoPO = JSON.parseObject(args, InfoPO.class);
            infoPO.setUserId(getUserId().intValue());
            Long result = infoFacade.insert(infoPO);
            if(result >0){
                return ResponseUtil.success();
            }else{
                return ResponseUtil.exception("用户信息增加失败");
            }
        } catch (Exception e) {
            logger.error(e);
            return ResponseUtil.unKonwException();
        }
    }

    @POST
    @Path("edit")
    @Produces(MediaType.APPLICATION_JSON)
    public String edit(String args)
    {
        try {
            InfoPO infoPO = JSON.parseObject(args, InfoPO.class);
            Long result = infoFacade.update(infoPO);
            if(result >0){
                return ResponseUtil.success();
            }else{
                return ResponseUtil.exception("用户信息更新失败");
            }
        } catch (Exception e) {
            logger.error(e);
            return ResponseUtil.unKonwException();
        }
    }

    @POST
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(String args)
    {
        try {
            InfoPO infoPO = JSON.parseObject(args, InfoPO.class);
            Long result = infoFacade.delete(infoPO.getUserId());
            if(result >0){
                return ResponseUtil.success();
            }else{
                return ResponseUtil.exception("用户信息删除失败");
            }
        } catch (Exception e) {
            logger.error(e);
            return ResponseUtil.unKonwException();
        }
    }
}
