package com.fengyu.facade.crowdfunding.entity.po;

import com.fengyu.common.entity.BaseEntity;

/**
 * 众筹项目收款人信息表
 *
 * @author Administrator
 * @create 2016 12 04 22:05
 */
public class CrowdFundingAcctPO extends BaseEntity{
    private Integer prjtId;
    private Integer userId;
    private String acctType;
    private String acctName;
    private Integer bankId;
    private Integer acctNo;
    private Integer openBankCity;
    private String acctOpenBank;
    private Integer openBankProvince;

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

    public String getAcctOpenBank() {
        return acctOpenBank;
    }

    public void setAcctOpenBank(String acctOpenBank) {
        this.acctOpenBank = acctOpenBank;
    }

    public Integer getOpenBankProvince() {
        return openBankProvince;
    }

    public void setOpenBankProvince(Integer openBankProvince) {
        this.openBankProvince = openBankProvince;
    }
}
