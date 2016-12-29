package com.fengyu.web.shop.action.member.setting.address;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.facade.user.address.entity.po.AddressPO;
import com.fengyu.facade.user.address.service.AddressFacade;
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

/**
 * @author guoz
 * @version V1.0
 * @date 2016/12/17
 */
@Component
@Path("/member/setting/address")
public class AddressAction extends BaseController{

    private static final Logger logger = LogManager.getLogger(AddressAction.class);

    @Autowired
    private AddressFacade addressFacade;

    @POST
    @Path("get")
    public String get(String args)
    {
        try {
            AddressPO addressPO = JSON.parseObject(args, AddressPO.class);
            AddressPO po = addressFacade.getById(addressPO.getId());
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
            PageBean pageBean = addressFacade.listPage(pageParam,map);
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
            AddressPO addressPO = JSON.parseObject(args, AddressPO.class);
            addressPO.setId(getUserId().intValue());
            Long result = addressFacade.insert(addressPO);
            if(result >0){
                return ResponseUtil.success();
            }else{
                return ResponseUtil.exception("收货地址增加失败");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            AddressPO addressPO = JSON.parseObject(args, AddressPO.class);
            Long result = addressFacade.update(addressPO);
            if(result >0){
                return ResponseUtil.success();
            }else{
                return ResponseUtil.exception("收货地址更新失败");
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
            AddressPO addressPO = JSON.parseObject(args, AddressPO.class);
            Long result = addressFacade.delete(addressPO.getId());
            if(result >0){
                return ResponseUtil.success();
            }else{
                return ResponseUtil.exception("收货地址删除失败");
            }
        } catch (Exception e) {
            logger.error(e);
            return ResponseUtil.unKonwException();
        }
    }


}
