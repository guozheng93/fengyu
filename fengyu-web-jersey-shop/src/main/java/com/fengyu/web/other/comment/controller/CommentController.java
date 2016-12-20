package com.fengyu.web.other.comment.controller;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.exception.MapperSupport.CommonExceptionType;
import com.fengyu.common.page.PageBean;
import com.fengyu.common.web.jersey.controller.BaseController;
import com.fengyu.common.web.jersey.wrapper.ResponseWrapper;
import com.fengyu.facade.crowdfunding.exception.CrowdExceptionHandler;
import com.fengyu.facade.crowdfunding.service.CrowdFundingEntityFacade;
import com.fengyu.facade.order.entity.vo.OrderVO;
import com.fengyu.facade.order.service.OrderFacade;
import com.fengyu.facade.other.comment.entity.po.CommentPO;
import com.fengyu.facade.other.comment.entity.po.CommentReplyPO;
import com.fengyu.facade.other.comment.entity.vo.CommentReplyVO;
import com.fengyu.facade.other.comment.entity.vo.CommentVO;
import com.fengyu.facade.other.comment.service.CommentFacade;
import com.fengyu.facade.user.entity.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.SecurityContext;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


@Component
@Path("/comment")
public class CommentController extends BaseController {

    @Autowired
    private CommentFacade commentFacade;

    /**
     * @author junz
     * @date 2016/12/4 20:51
     * @description 获取最底层众筹类目列表
     * @param
     * @return
    **/
    @POST
    @Path("getComment4Prjt")
    public String getComment4Prjt(String args)
    {
        CommentVO commentVO= JSON.parseObject(args, CommentVO.class);
        ResponseWrapper responseWrapper= new ResponseWrapper();
        try {
             List<CommentVO> voList=commentFacade.getPageList4Comment(commentVO);
            for (int i = 0; i < voList.size(); i++) {
                CommentReplyVO commentReply=new CommentReplyVO();
                commentReply.setCommentId(voList.get(i).getId());
                List<CommentReplyVO> voReplyList=commentFacade.getCommentReplyList(commentReply);
                voList.get(i).setCommentReplyList(voReplyList);
            }
            PageBean pageBean=new PageBean(voList);
            responseWrapper.setResponseBody(pageBean);
        } catch (Exception e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND);
        }
        String jsonStr=nullParamOfJsonFilter(responseWrapper);

        return jsonStr;
    }

    @POST
    @Path("commentReply4Prjt")
    public String commentReply4Prjt(String args) {
        CommentReplyVO commentReplyVO= JSON.parseObject(args, CommentReplyVO.class);
        UserVO user= getUser();
        commentReplyVO.setFromUid(user.getId());
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            CommentReplyPO commentReplyPO=commentFacade.commentReply4Prjt(commentReplyVO);
            responseWrapper=new ResponseWrapper(JSON.parseObject(JSON.toJSONString(commentReplyPO), Map.class));
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (Exception e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

    @POST
    @Path("comment4Prjt")
    public String comment4Prjt(String args) {
        CommentVO commentVO= JSON.parseObject(args, CommentVO.class);
        UserVO user= getUser();
        commentVO.setFromUid(user.getId());
        ResponseWrapper responseWrapper= null;
        String jsonStr="";
        try {
            CommentPO commentPO=commentFacade.comment4Prjt(commentVO);
            responseWrapper=new ResponseWrapper(JSON.parseObject(JSON.toJSONString(commentPO), Map.class));
            jsonStr=nullParamOfJsonFilter(responseWrapper);
        } catch (Exception e) {
            throw  new CrowdExceptionHandler(e, CommonExceptionType.METHODNOTFOUND,args);

        }
        return jsonStr;
    }

}
