package com.fengyu.facade.crowdfunding.entity.po;

import com.fengyu.common.entity.BaseEntity;

/**
 * 众筹项目收款人信息表
 *
 * @author Administrator
 * @create 2016 12 04 22:05
 */
public class CrowdFundingFocusPO extends BaseEntity{
    private Integer prjtId             ;
    private Integer userId            ;
    private String focusTime   ;
    private String status        ;

    public Integer getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(Integer prjtId) {
        this.prjtId = prjtId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFocusTime() {
        return focusTime;
    }

    public void setFocusTime(String focusTime) {
        this.focusTime = focusTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
