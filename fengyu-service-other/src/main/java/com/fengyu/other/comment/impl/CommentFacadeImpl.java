package com.fengyu.other.comment.impl;

import com.alibaba.fastjson.JSON;
import com.fengyu.common.core.base.service.impl.BaseServiceImpl;
import com.fengyu.common.utils.BeanUtils;
import com.fengyu.facade.other.comment.entity.po.CommentPO;
import com.fengyu.facade.other.comment.entity.po.CommentReplyPO;
import com.fengyu.facade.other.comment.entity.vo.CommentReplyVO;
import com.fengyu.facade.other.comment.entity.vo.CommentVO;
import com.fengyu.facade.other.comment.service.CommentFacade;
import com.fengyu.facade.other.common.entity.vo.BizDictionaryVO;
import com.fengyu.other.comment.dao.CommentDao;
import com.fengyu.other.comment.dao.CommentReplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service(value = "commentFacade")
@Transactional
public class CommentFacadeImpl extends BaseServiceImpl implements CommentFacade {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private CommentReplyDao commentReplyDao;


    @Override
    public List<CommentVO> getPageList4Comment(CommentVO commentVO) {
        List<CommentVO> voList=null;
        List list=commentDao.getPageList4Comment(JSON.parseObject(JSON.toJSONString(commentVO),Map.class));
        voList=super.getObjectTransformer().defaulBatchtExcute(
                list
                ,CommentVO.class
        ) ;
        return voList;
    }

    @Override
    public List<CommentReplyVO> getCommentReplyList(CommentReplyVO commentReplyVO) {
        List<CommentReplyVO> voList=null;
        List list=commentReplyDao.getCommentReplyList(JSON.parseObject(JSON.toJSONString(commentReplyVO),Map.class));
        voList=super.getObjectTransformer().defaulBatchtExcute(
                list
                ,CommentReplyVO.class
        ) ;
        return voList;
    }

    @Override
    public CommentReplyPO commentReply4Prjt(CommentReplyVO commentReplyVO) {

        CommentReplyPO commentReplyPO=JSON.parseObject(JSON.toJSONString(commentReplyVO),CommentReplyPO.class);
        commentReplyDao.commentReply4Prjt(commentReplyPO);
        return commentReplyPO;
    }

    @Override
    public CommentPO comment4Prjt(CommentVO commentVO) {
        CommentPO commentPO=JSON.parseObject(JSON.toJSONString(commentVO),CommentPO.class);
        commentDao.comment4Prjt(commentPO);
        return commentPO;
    }
}
