package com.fengyu.facade.crowdfunding.entity.vo;

import com.fengyu.common.entity.VOEntity;

/**
 * 众筹项目收款人信息表
 *
 * @author Administrator
 * @create 2016 12 04 22:05
 */
public class CrowdFundingAcctVO extends VOEntity{
    private Integer prjtId;
    private Integer userId;
    private String acctType;
    private String acctTypeName;
    private String acctName;
    private Integer bankId;
    private Integer acctNo;
    private Integer openBankCity;
    private Integer openBankCityName;
    private Integer acctOpenBank;
    private Integer acctOpenBankName;
    private Integer openBankProvince;
    private Integer openBankProvinceName;

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

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getAcctTypeName() {
        return acctTypeName;
    }

    public void setAcctTypeName(String acctTypeName) {
        this.acctTypeName = acctTypeName;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Integer getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(Integer acctNo) {
        this.acctNo = acctNo;
    }

    public Integer getOpenBankCity() {
        return openBankCity;
    }

    public void setOpenBankCity(Integer openBankCity) {
        this.openBankCity = openBankCity;
    }

    public Integer getOpenBankCityName() {
        return openBankCityName;
    }

    public void setOpenBankCityName(Integer openBankCityName) {
        this.openBankCityName = openBankCityName;
    }

    public Integer getAcctOpenBank() {
        return acctOpenBank;
    }

    public void setAcctOpenBank(Integer acctOpenBank) {
        this.acctOpenBank = acctOpenBank;
    }

    public Integer getAcctOpenBankName() {
        return acctOpenBankName;
    }

    public void setAcctOpenBankName(Integer acctOpenBankName) {
        this.acctOpenBankName = acctOpenBankName;
    }

    public Integer getOpenBankProvince() {
        return openBankProvince;
    }

    public void setOpenBankProvince(Integer openBankProvince) {
        this.openBankProvince = openBankProvince;
    }

    public Integer getOpenBankProvinceName() {
        return openBankProvinceName;
    }

    public void setOpenBankProvinceName(Integer openBankProvinceName) {
        this.openBankProvinceName = openBankProvinceName;
    }
}
