package com.fengyu.other.comment.dao;


import com.fengyu.common.core.annotation.MyBatisDao;
import com.fengyu.common.core.dao.BaseDao;
import com.fengyu.facade.other.comment.entity.po.CommentPO;
import com.fengyu.facade.other.comment.entity.po.CommentReplyPO;


import java.util.List;
import java.util.Map;

@MyBatisDao
public interface CommentDao extends BaseDao<CommentPO>{

    public List<Map<String,Object>> getPageList4Comment(Map map);
    public Integer comment4Prjt(CommentPO commentPO);

}
