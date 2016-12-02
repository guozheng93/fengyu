package com.fengyu.facade.user.entity;

import com.fengyu.common.entity.BaseEntity;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/1
 */
public class User extends BaseEntity {

    private String loginName;
    private String password;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
