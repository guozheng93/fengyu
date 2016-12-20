package com.fengyu.facade.crowdfunding.entity.po;

import com.fengyu.common.entity.BaseEntity;

import java.util.List;

/**
 * 众筹项目基础bean
 *
 * @author junz
 * @create 2016 12 04 21:06
 */
public class CrowdFundingPublicityPO extends BaseEntity{
    private Integer prjtId;
    private String author;
    private String message;
    private String publicityTime;

    public Integer getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(Integer prjtId) {
        this.prjtId = prjtId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPublicityTime() {
        return publicityTime;
    }

    public void setPublicityTime(String publicityTime) {
        this.publicityTime = publicityTime;
    }
}
