package com.fengyu.facade.user.login.entity.po;

import com.fengyu.common.entity.BaseEntity;
import com.fengyu.common.entity.Token;

import java.util.Date;

/**
 * 众筹项目收款人信息表
 *
 * @author Administrator
 * @create 2016 12 04 22:05
 */
public class UserPO extends BaseEntity {
    private String username;
    private String phone        ;
    private String password     ;
    private String email        ;
    private Boolean isValid     ;
    private String qqId        ;
    private String wxId        ;
    private String wbId        ;
    private Boolean isAuth      ;
    private Date createTime  ;
    private Date updateTime;
    private Date lastTime ;
    private Token mainToken;
    private Token accessToken;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Token getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Token accessToken) {
        this.accessToken = accessToken;
    }

    public Token getMainToken() {
        return mainToken;
    }

    public void setMainToken(Token mainToken) {
        this.mainToken = mainToken;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getWbId() {
        return wbId;
    }

    public void setWbId(String wbId) {
        this.wbId = wbId;
    }

    public Boolean getAuth() {
        return isAuth;
    }

    public void setAuth(Boolean auth) {
        isAuth = auth;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}
