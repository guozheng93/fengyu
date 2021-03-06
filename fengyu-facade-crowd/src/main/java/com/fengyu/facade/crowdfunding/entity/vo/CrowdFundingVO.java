package com.fengyu.facade.crowdfunding.entity.vo;

import com.fengyu.common.entity.BaseEntity;
import com.fengyu.common.entity.VOEntity;

/**
 * 众筹项目基础bean
 *
 * @author junz
 * @create 2016 12 04 21:06
 */
public class CrowdFundingVO extends VOEntity {
    //众筹项目名称
    private String prjtName;
    private Integer prjtUserId;
    private Integer prjtOrganiserId;
    //众筹项目类型id
    private Integer prjtItemId;
    //众筹项目类型id
    private Integer prjtItemName;
    //项目简介摘要
    private String prjtSummary;
    //募集对象类型 MONEY
    private String prjtRaiseType;

    //募集对象类型 MONEY
    private String prjtRaiseTypeName;
    //筹集目标额度
    private Double prjtRaiseAmount;
    //筹集上限
    private Double prjtRaiseToplimit;
    //筹集周期
    private Integer prjtFundCycle;
    //项目提交日期
    private String prjtCommitTime;
    //项目提交日期
    private String prjtFundingTime;
    //项目提交日期
    private String prjtEndTime;
    //项目状态
    private String prjtStatus;
    //项目状态
    private String prjtStatusName;

    public String getPrjtFundingTime() {
        return prjtFundingTime;
    }

    public void setPrjtFundingTime(String prjtFundingTime) {
        this.prjtFundingTime = prjtFundingTime;
    }

    public String getPrjtEndTime() {
        return prjtEndTime;
    }

    public void setPrjtEndTime(String prjtEndTime) {
        this.prjtEndTime = prjtEndTime;
    }

    public Integer getPrjtUserId() {
        return prjtUserId;
    }

    public void setPrjtUserId(Integer prjtUserId) {
        this.prjtUserId = prjtUserId;
    }

    public Integer getPrjtOrganiserId() {
        return prjtOrganiserId;
    }

    public void setPrjtOrganiserId(Integer prjtOrganiserId) {
        this.prjtOrganiserId = prjtOrganiserId;
    }

    public Integer getPrjtItemName() {
        return prjtItemName;
    }

    public void setPrjtItemName(Integer prjtItemName) {
        this.prjtItemName = prjtItemName;
    }

    public String getPrjtRaiseTypeName() {
        return prjtRaiseTypeName;
    }

    public void setPrjtRaiseTypeName(String prjtRaiseTypeName) {
        this.prjtRaiseTypeName = prjtRaiseTypeName;
    }

    public String getPrjtStatusName() {
        return prjtStatusName;
    }

    public void setPrjtStatusName(String prjtStatusName) {
        this.prjtStatusName = prjtStatusName;
    }

    public String getPrjtName() {
        return prjtName;
    }

    public void setPrjtName(String prjtName) {
        this.prjtName = prjtName;
    }

    public Integer getPrjtItemId() {
        return prjtItemId;
    }

    public void setPrjtItemId(Integer prjtItemId) {
        this.prjtItemId = prjtItemId;
    }

    public String getPrjtSummary() {
        return prjtSummary;
    }

    public void setPrjtSummary(String prjtSummary) {
        this.prjtSummary = prjtSummary;
    }

    public String getPrjtRaiseType() {
        return prjtRaiseType;
    }

    public void setPrjtRaiseType(String prjtRaiseType) {
        this.prjtRaiseType = prjtRaiseType;
    }

    public Double getPrjtRaiseAmount() {
        return prjtRaiseAmount;
    }

    public void setPrjtRaiseAmount(Double prjtRaiseAmount) {
        this.prjtRaiseAmount = prjtRaiseAmount;
    }

    public Double getPrjtRaiseToplimit() {
        return prjtRaiseToplimit;
    }

    public void setPrjtRaiseToplimit(Double prjtRaiseToplimit) {
        this.prjtRaiseToplimit = prjtRaiseToplimit;
    }

    public Integer getPrjtFundCycle() {
        return prjtFundCycle;
    }

    public void setPrjtFundCycle(Integer prjtFundCycle) {
        this.prjtFundCycle = prjtFundCycle;
    }

    public String getPrjtCommitTime() {
        return prjtCommitTime;
    }

    public void setPrjtCommitTime(String prjtCommitTime) {
        this.prjtCommitTime = prjtCommitTime;
    }

    public String getPrjtStatus() {
        return prjtStatus;
    }

    public void setPrjtStatus(String prjtStatus) {
        this.prjtStatus = prjtStatus;
    }
}
