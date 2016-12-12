package com.fengyu.facade.crowdfunding.entity.vo;

import com.fengyu.common.entity.BaseEntity;
import com.fengyu.common.entity.VOEntity;

/**
 * 项目发起人po表
 *
 * @author Administrator
 * @create 2016 12 04 21:24
 */
public class CrowdFundingOrganiserVO extends VOEntity {
    private String  userId;
    private String  orgnrResume;
    private String  orgnrBlog;
    private String  orgnrBlessWord;
    private String  orgnrTelephone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgnrResume() {
        return orgnrResume;
    }

    public void setOrgnrResume(String orgnrResume) {
        this.orgnrResume = orgnrResume;
    }

    public String getOrgnrBlog() {
        return orgnrBlog;
    }

    public void setOrgnrBlog(String orgnrBlog) {
        this.orgnrBlog = orgnrBlog;
    }

    public String getOrgnrBlessWord() {
        return orgnrBlessWord;
    }

    public void setOrgnrBlessWord(String orgnrBlessWord) {
        this.orgnrBlessWord = orgnrBlessWord;
    }

    public String getOrgnrTelephone() {
        return orgnrTelephone;
    }

    public void setOrgnrTelephone(String orgnrTelephone) {
        this.orgnrTelephone = orgnrTelephone;
    }
}
