package com.fengyu.other.comment.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.other.comment.entity.po.CommentReplyPO;


import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CommentReplyDao extends BaseDao<CommentReplyPO>{

    public List<Map<String,Object>> getCommentReplyList(Map map);
    public Integer commentReply4Prjt(CommentReplyPO commentReplyPO);
}
