package com.fengyu.facade.order.entity.vo;

import com.fengyu.common.entity.VOEntity;

/**
 * 众筹项目收款人信息表
 *
 * @author Administrator
 * @create 2016 12 04 22:05
 */
public class OrderVO extends VOEntity{
    private Integer prjtId;
    private Double orderAmt=0.0;
    private Integer orderPartyA;
    private String orderTime;
    private String orderStatus;
    private String merchandiseType;
    private Integer merchandiseId;
    private Double orderQuantity=0.0;
    private String orderRemark;
    private Integer sumSupportors=0;

    public Integer getSumSupportors() {
        return sumSupportors;
    }

    public void setSumSupportors(Integer sumSupportors) {
        this.sumSupportors = sumSupportors;
    }

    public Integer getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(Integer prjtId) {
        this.prjtId = prjtId;
    }

    public Double getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(Double orderAmt) {
        this.orderAmt = orderAmt;
    }

    public Integer getOrderPartyA() {
        return orderPartyA;
    }

    public void setOrderPartyA(Integer orderPartyA) {
        this.orderPartyA = orderPartyA;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getMerchandiseType() {
        return merchandiseType;
    }

    public void setMerchandiseType(String merchandiseType) {
        this.merchandiseType = merchandiseType;
    }

    public Integer getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(Integer merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public Double getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }
}
