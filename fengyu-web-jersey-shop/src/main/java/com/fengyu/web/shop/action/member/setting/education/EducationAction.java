package com.fengyu.web.shop.action.member.setting.education;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.facade.user.education.entity.po.EducationPO;
import com.fengyu.facade.user.education.service.EducationFacade;
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
@Path("/member/setting/education")
public class EducationAction extends BaseController{

    private static final Logger logger = LogManager.getLogger(EducationAction.class);

    @Autowired
    private EducationFacade educationFacade;

    @POST
    @Path("get")
    public String get(String args)
    {
        try {
            EducationPO educationPO = JSON.parseObject(args, EducationPO.class);
            EducationPO po = educationFacade.getById(educationPO.getId());
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
            map.put("userId",getUserId());
            PageBean pageBean = educationFacade.listPage(pageParam,map);
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
            EducationPO educationPO = JSON.parseObject(args, EducationPO.class);
            educationPO.setId(getUserId().intValue());
            Long result = educationFacade.insert(educationPO);
            if(result >0){
                return ResponseUtil.success();
            }else{
                return ResponseUtil.exception("学历信息增加失败");
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
            EducationPO educationPO = JSON.parseObject(args, EducationPO.class);
            Long result = educationFacade.update(educationPO);
            if(result >0){
                return ResponseUtil.success();
            }else{
                return ResponseUtil.exception("学历信息更新失败");
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
            EducationPO educationPO = JSON.parseObject(args, EducationPO.class);
            Long result = educationFacade.delete(educationPO.getId());
            if(result >0){
                return ResponseUtil.success();
            }else{
                return ResponseUtil.exception("学历信息删除失败");
            }
        } catch (Exception e) {
            logger.error(e);
            return ResponseUtil.unKonwException();
        }
    }


}
