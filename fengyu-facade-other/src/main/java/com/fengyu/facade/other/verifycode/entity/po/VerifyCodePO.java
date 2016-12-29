package com.fengyu.facade.other.verifycode.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoz
 * @version V1.0
 * @date 2016/12/17
 */
public class VerifyCodePO implements Serializable{

    private Integer id;
    private Integer userId;
    private String verifyCode;
    private Integer verifyCodeType;
    private String bizType;
    private String sendTarget;
    private Date deadTime;
    private Date genTime;
    private String sendResult;
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Integer getVerifyCodeType() {
        return verifyCodeType;
    }

    public void setVerifyCodeType(Integer verifyCodeType) {
        this.verifyCodeType = verifyCodeType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getSendTarget() {
        return sendTarget;
    }

    public void setSendTarget(String sendTarget) {
        this.sendTarget = sendTarget;
    }

    public Date getDeadTime() {
        return deadTime;
    }

    public void setDeadTime(Date deadTime) {
        this.deadTime = deadTime;
    }

    public Date getGenTime() {
        return genTime;
    }

    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    public String getSendResult() {
        return sendResult;
    }

    public void setSendResult(String sendResult) {
        this.sendResult = sendResult;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
