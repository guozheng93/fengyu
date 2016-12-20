package com.fengyu.web.crowdfunding.controller;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.entity.VOEntity;
import com.fengyu.common.exception.MapperSupport.CommonExceptionType;
import com.fengyu.common.page.PageBean;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.common.web.jersey.wrapper.ResponseWrapper;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingEntityPO;
import com.fengyu.facade.crowdfunding.entity.po.CrowdFundingFocusPO;
import com.fengyu.facade.crowdfunding.entity.vo.*;
import com.fengyu.facade.crowdfunding.enums.CrowdFundingEnum;
import com.fengyu.facade.crowdfunding.exception.CrowdExceptionHandler;
import com.fengyu.facade.crowdfunding.service.CrowdFundingEntityFacade;
import com.fengyu.facade.crowdfunding.service.CrowdFundingRepayFacade;
import com.fengyu.facade.order.entity.vo.OrderVO;
import com.fengyu.facade.order.enums.OrderEnum;
import com.fengyu.facade.order.service.OrderFacade;
import com.fengyu.facade.other.comment.entity.vo.CommentReplyVO;
import com.fengyu.facade.user.entity.vo.UserVO;
import com.sun.tools.internal.xjc.reader.gbind.ElementSets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


@Component
@Path("/crowdFundingEntity")
public class CrowdFundingEntityController extends BaseController {

    @Autowired
    private CrowdFundingEntityFacade crowdFundingEntityFacade;

    @Autowired
    private OrderFacade orderFacade;
    @Autowired
    private CrowdFundingRepayFacade crowdFundingRepayFacade;
    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 新增众筹项目。各表初始化
     * @param
     * @return
     **/
    @POST
    @Path("submitPrjt")
    public String submitPrjt(String args)
    {
        CrowdFundingEntityVO crowdFundingEntityVO= JSON.parseObject(args, CrowdFundingEntityVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"submitPrjt",crowdFundingEntityVO);
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
     * @description 新增众筹项目。各表初始化
     * @param
     * @return
     **/
    @POST
    @Path("getCrowdFundingDetail")
    public String getCrowdFundingDetail (String args)
    {
        CrowdFundingDetailVO crowdFundingDetailVO= JSON.parseObject(args, CrowdFundingDetailVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"getCrowdFundingEntityDetail",crowdFundingDetailVO);
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
        crowdFundingAcctVO.setUserId(((UserVO)securityContext.getUserPrincipal()).getId());
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
        crowdFundingAcctVO.setUserId(((UserVO)securityContext.getUserPrincipal()).getId());
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
        Map acctParamMap= com.alibaba.fastjson.JSON.parseObject(args.length()>0?args:"{}", Map.class);
        UserVO user= (UserVO) securityContext.getUserPrincipal();
        acctParamMap.put("userId",user.getId());

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
    @POST
    @Path("getCrowdFundingOrganiserInfo")
    public String getCrowdFundingOrganiserInfo(String args) {
        CrowdFundingOrganiserVO crowdFundingOrganiserVO= JSON.parseObject(args, CrowdFundingOrganiserVO.class);
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            responseWrapper = doServiceAndResponse(crowdFundingEntityFacade,"getCrowdFundingOrganiserInfo",crowdFundingOrganiserVO);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (InvocationTargetException e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    @POST
    @Path("getCrdFdEntityProgess")
    public String getCrdFdEntityProgess(String args) {
        Map map= JSON.parseObject(args, Map.class);
        ResponseWrapper responseWrapper= new ResponseWrapper();
        String jsonStr="";
        Map returnMap=new HashMap();
        try {

            CrowdFundingEntityVO crowdFundingEntityVO=new CrowdFundingEntityVO();
            crowdFundingEntityVO.setId(Integer.parseInt(map.get("id").toString()));
            crowdFundingEntityVO=crowdFundingEntityFacade.getCrowdFundingEntityInfo(crowdFundingEntityVO);
            //募集金额
            double sumAmt=0;
            //目标金额
            double prjtRaiseAmount=crowdFundingEntityVO.getPrjtRaiseAmount();

            //统计募集金额以及募集人数
            OrderVO orderVo=new OrderVO();
            orderVo.setPrjtId(crowdFundingEntityVO.getId());
            orderVo.setOrderStatus(OrderEnum.OrderStatus.ORDER_STATUS_PAIDED.getCode());
            orderVo=orderFacade.getOrderOverview(orderVo);

            returnMap.put("prjtSumAmt",orderVo.getOrderAmt());
            returnMap.put("prjtRaiseAmount",prjtRaiseAmount);
            returnMap.put("prjtsumSupportors",orderVo.getSumSupportors());
            returnMap.put("prjtfundingTime",crowdFundingEntityVO.getPrjtFundingTime());
            returnMap.put("prjtEndTime",crowdFundingEntityVO.getPrjtEndTime());
            List list=new ArrayList();
            list.add(returnMap);
            PageBean page=new PageBean();
            page.setRecordList(list);
            page.setTotalCount(1);
            responseWrapper.setResponseBody(page);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (Exception e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }


    @POST
    @Path("getCrdFdEntityTotalFocus")
    public String getCrdFdEntityTotalFocus(String args) {
        CrowdFundingFocusVO crowdFundingFocusVO= JSON.parseObject(args, CrowdFundingFocusVO.class);
        crowdFundingFocusVO.setUserId(getUser().getId());
        ResponseWrapper responseWrapper= new ResponseWrapper();
        String jsonStr="";
        try
        {
            Integer totalFocus=crowdFundingEntityFacade.getTotalFocus(crowdFundingFocusVO);
            Map map=new HashMap();
            map.put("crdFdTotalFocus",totalFocus);
            List list=new ArrayList();
            list.add(map);
            PageBean page=new PageBean();
            page.setRecordList(list);
            responseWrapper.setResponseBody(page);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (Exception e)
        {
            throw new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);
        }
        return jsonStr;
    }

    @POST
    @Path("getCrdFdEntityTotalPraise")
    public String getCrdFdEntityTotalPraise(String args) {
        CrowdFundingPraiseVO crowdFundingPraiseVO= JSON.parseObject(args, CrowdFundingPraiseVO.class);
        crowdFundingPraiseVO.setUserId(getUser().getId());
        ResponseWrapper responseWrapper= new ResponseWrapper();
        String jsonStr="";
        try
        {
            Integer totalPraise=crowdFundingEntityFacade.getTotalPraise(crowdFundingPraiseVO);
            Map map=new HashMap();
            map.put("crdFdTotalPraise",totalPraise);
            List list=new ArrayList();
            list.add(map);
            PageBean page=new PageBean();
            page.setRecordList(list);
            responseWrapper.setResponseBody(page);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (Exception e)
        {
            throw new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);
        }
        return jsonStr;
    }

    @POST
    @Path("praiseCrdFdAction")
    public String praiseCrdFdAction(String args) {
        CrowdFundingPraiseVO crowdFundingPraiseVO= JSON.parseObject(args, CrowdFundingPraiseVO.class);
        crowdFundingPraiseVO.setUserId(getUser().getId());
        ResponseWrapper responseWrapper= new ResponseWrapper();
        String jsonStr="";
        String praiseStatus=crowdFundingPraiseVO.getStatus();
        crowdFundingPraiseVO.setStatus(null);
        try
        {
            List<CrowdFundingPraiseVO> voList=crowdFundingEntityFacade.getPraiseList(crowdFundingPraiseVO);
            //判断动作是否重复
            if(voList!=null&&voList.size()>0&&voList.get(0).getStatus().equals(praiseStatus))
            {
                if(CrowdFundingEnum
                        .CrowdFundingHeatType
                        .CROWD_FUNDING_HEAT_TYPE_PRAISE_TYPE_CANNEL
                        .getCode().equals(praiseStatus)
                        )
                //返回操作失败状态
                responseWrapper.setReturnCode(CrowdFundingEnum
                        .CrowdFundingHeatType.CROWD_FUNDING_HEAT_TYPE_ISCANNELPRAISE.getCode());

                if(CrowdFundingEnum
                        .CrowdFundingHeatType
                        .CROWD_FUNDING_HEAT_TYPE_PRAISE_TYPE_NORMAL
                        .getCode().equals(praiseStatus)
                        )
                    //返回操作失败状态
                    responseWrapper.setReturnCode(CrowdFundingEnum
                            .CrowdFundingHeatType.CROWD_FUNDING_HEAT_TYPE_ISPRAISE.getCode());

            }else {
                crowdFundingPraiseVO.setStatus(praiseStatus);
                crowdFundingEntityFacade.newTotalPraise(crowdFundingPraiseVO);
            }

            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (Exception e)
        {
            throw new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);
        }
        return jsonStr;
    }

    @POST
    @Path("focusCrdFdAction")
    public String focusCrdFdAction(String args) {
        CrowdFundingFocusVO crowdFundingFocusVO= JSON.parseObject(args, CrowdFundingFocusVO.class);
        crowdFundingFocusVO.setUserId(getUser().getId());
        ResponseWrapper responseWrapper= new ResponseWrapper();
        String jsonStr="";
        String focusStatus=crowdFundingFocusVO.getStatus();
        crowdFundingFocusVO.setStatus(null);
        try
        {
            List<CrowdFundingFocusVO> voList=crowdFundingEntityFacade.getFocusList(crowdFundingFocusVO);
            //判断动作是否重复
            if(voList!=null&&voList.size()>0&&voList.get(0).getStatus().equals(focusStatus))
            {
                if(CrowdFundingEnum
                        .CrowdFundingHeatType
                        .CROWD_FUNDING_HEAT_TYPE_FOCUS_TYPE_CANNEL
                        .getCode().equals(focusStatus)
                        )
                    //返回操作失败状态
                    responseWrapper.setReturnCode(CrowdFundingEnum
                            .CrowdFundingHeatType.CROWD_FUNDING_HEAT_TYPE_ISCANNELFOCUS.getCode());

                if(CrowdFundingEnum
                        .CrowdFundingHeatType
                        .CROWD_FUNDING_HEAT_TYPE_FOCUS_TYPE_NORMAL
                        .getCode().equals(focusStatus)
                        )
                    //返回操作失败状态
                    responseWrapper.setReturnCode(CrowdFundingEnum
                            .CrowdFundingHeatType.CROWD_FUNDING_HEAT_TYPE_ISFOCUS.getCode());

            }else {
                crowdFundingFocusVO.setStatus(focusStatus);
                crowdFundingEntityFacade.newTotalFocus(crowdFundingFocusVO);
            }

            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (Exception e)
        {
            throw new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);
        }
        return jsonStr;
    }

    @POST
    @Path("getPrjtFocusStatus")
    public String getPrjtFocusStatus(String args) {
        CrowdFundingFocusVO crowdFundingFocusVO= JSON.parseObject(args, CrowdFundingFocusVO.class);
        crowdFundingFocusVO.setUserId(getUser().getId());
        ResponseWrapper responseWrapper= new ResponseWrapper();
        String jsonStr="";
        try
        {
            PageBean page=new PageBean();
            List list=new ArrayList();
            List<CrowdFundingFocusVO> voList=crowdFundingEntityFacade.getFocusList(crowdFundingFocusVO);
            if(voList!=null&&voList.size()>0)
            {
                Map map=new HashMap();
                map.put("status",voList.get(0).getStatus());
                list.add(map);
                page.setRecordList(list);
            }
            responseWrapper.setResponseBody(page);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (Exception e)
        {
            throw new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);
        }
        return jsonStr;
    }

    @POST
    @Path("getPrjtPraiseStatus")
    public String getPrjtPraiseStatus(String args) {
        CrowdFundingPraiseVO crowdFundingPraiseVO= JSON.parseObject(args, CrowdFundingPraiseVO.class);
        crowdFundingPraiseVO.setUserId(getUser().getId());
        ResponseWrapper responseWrapper= new ResponseWrapper();
        String jsonStr="";
        try
        {
            PageBean page=new PageBean();
            List list=new ArrayList();
            List<CrowdFundingPraiseVO> voList=crowdFundingEntityFacade.getPraiseList(crowdFundingPraiseVO);
            if(voList!=null&&voList.size()>0)
            {
                Map map=new HashMap();
                map.put("status",voList.get(0).getStatus());
                list.add(map);
                page.setRecordList(list);
            }
            responseWrapper.setResponseBody(page);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (Exception e)
        {
            throw new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);
        }
        return jsonStr;
    }

    @POST
    @Path("getPageList4CrdFdEntityDynamics")
    public String getPageList4CrdFdEntityDynamics(String args) {
        CrowdFundingPublicityVO crowdFundingPublicityVO= JSON.parseObject(args, CrowdFundingPublicityVO.class);
        ResponseWrapper responseWrapper= new ResponseWrapper();


        String jsonStr="";
        try {
            List<CrowdFundingPublicityVO> voList= crowdFundingEntityFacade.getPageList4CrdFdEntityDynamics(crowdFundingPublicityVO);
            for (int i = 0; i < voList.size(); i++) {
                CrowdFundingPublicityImgVO imgVo=new CrowdFundingPublicityImgVO();
                imgVo.setPublicityId(voList.get(i).getId());
                List<CrowdFundingPublicityImgVO> imgList=crowdFundingEntityFacade.getCrdFdEntityDynamicsImgList(imgVo);
                voList.get(i).setPublicityImgs(imgList);
            }
            PageBean page=new PageBean(voList);
            responseWrapper.setResponseBody(page);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (Exception e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    @POST
    @Path("getPageList4CrdFdEntity")
    public String getPageList4CrdFdEntity(String args) {
        CrowdFundingEntityVO crowdFundingEntityVO= JSON.parseObject(args, CrowdFundingEntityVO.class);
        ResponseWrapper responseWrapper= new ResponseWrapper();
        String jsonStr="";
        try {
            List<CrowdFundingEntityVO> voList= crowdFundingEntityFacade.getPageList4CrdFdEntity(crowdFundingEntityVO);

            PageBean page=new PageBean(voList);
            responseWrapper.setResponseBody(page);
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (Exception e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

}
