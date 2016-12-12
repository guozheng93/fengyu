package com.fengyu.facade.crowdfunding.entity.vo;

import com.fengyu.common.entity.VOEntity;

/**
 * 项目回报基本信息表
 *
 * @author Administrator
 * @create 2016 12 04 21:30
 */
public class CrowdFundingRepayVO extends VOEntity{
    private Integer prjtId;
    private String repayType;
    private String repayTypeName;
    private String repayPrice;
    private String repayDetail  ;
    private Integer repayNeedRemark  ;
    private String repayRemark;
    private Integer repayLimitAmount;
    private String repayExpressFee;
    private Integer repayInvoiceFlag;
    private String repayInvoiceRemark;
    private String repayTime;
    private String repayImage;
    private String repayImageThumbnail;

    public String getRepayTypeName() {
        return repayTypeName;
    }

    public void setRepayTypeName(String repayTypeName) {
        this.repayTypeName = repayTypeName;
    }

    public String getRepayImage() {
        return repayImage;
    }

    public void setRepayImage(String repayImage) {
        this.repayImage = repayImage;
    }

    public String getRepayImageThumbnail() {
        return repayImageThumbnail;
    }

    public void setRepayImageThumbnail(String repayImageThumbnail) {
        this.repayImageThumbnail = repayImageThumbnail;
    }

    public Integer getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(Integer prjtId) {
        this.prjtId = prjtId;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public String getRepayPrice() {
        return repayPrice;
    }

    public void setRepayPrice(String repayPrice) {
        this.repayPrice = repayPrice;
    }

    public String getRepayDetail() {
        return repayDetail;
    }

    public void setRepayDetail(String repayDetail) {
        this.repayDetail = repayDetail;
    }

    public Integer getRepayNeedRemark() {
        return repayNeedRemark;
    }

    public void setRepayNeedRemark(Integer repayNeedRemark) {
        this.repayNeedRemark = repayNeedRemark;
    }

    public String getRepayRemark() {
        return repayRemark;
    }

    public void setRepayRemark(String repayRemark) {
        this.repayRemark = repayRemark;
    }

    public Integer getRepayLimitAmount() {
        return repayLimitAmount;
    }

    public void setRepayLimitAmount(Integer repayLimitAmount) {
        this.repayLimitAmount = repayLimitAmount;
    }

    public String getRepayExpressFee() {
        return repayExpressFee;
    }

    public void setRepayExpressFee(String repayExpressFee) {
        this.repayExpressFee = repayExpressFee;
    }

    public Integer getRepayInvoiceFlag() {
        return repayInvoiceFlag;
    }

    public void setRepayInvoiceFlag(Integer repayInvoiceFlag) {
        this.repayInvoiceFlag = repayInvoiceFlag;
    }

    public String getRepayInvoiceRemark() {
        return repayInvoiceRemark;
    }

    public void setRepayInvoiceRemark(String repayInvoiceRemark) {
        this.repayInvoiceRemark = repayInvoiceRemark;
    }

    public String getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(String repayTime) {
        this.repayTime = repayTime;
    }
}
