package com.fengyu.facade.other.comment.entity.po;

import com.fengyu.common.entity.BaseEntity;

/**
 * 众筹项目收款人信息表
 *
 * @author Administrator
 * @create 2016 12 04 22:05
 */
public class CommentPO extends BaseEntity{
    private Integer topicId;
    private String topicType;
    private String commentContent;
    private Integer fromUid;
    private String CommentTime;

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }



    public String getCommentTime() {
        return CommentTime;
    }

    public void setCommentTime(String commentTime) {
        CommentTime = commentTime;
    }
}
