package com.fengyu.facade.other.comment.service;

import com.fengyu.common.core.base.service.BaseService;
import com.fengyu.facade.other.comment.entity.po.CommentPO;
import com.fengyu.facade.other.comment.entity.po.CommentReplyPO;
import com.fengyu.facade.other.comment.entity.vo.CommentReplyVO;
import com.fengyu.facade.other.comment.entity.vo.CommentVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/2.
 */
public interface CommentFacade extends BaseService{
    public List<CommentVO> getPageList4Comment(CommentVO commentVO);

    public List<CommentReplyVO> getCommentReplyList(CommentReplyVO commentReplyVO);

    public CommentReplyPO commentReply4Prjt(CommentReplyVO commentReplyVO);
    public CommentPO comment4Prjt(CommentVO commentVO);


}
