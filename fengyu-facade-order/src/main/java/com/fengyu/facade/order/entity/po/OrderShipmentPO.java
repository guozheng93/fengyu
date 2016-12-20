package com.fengyu.facade.order.entity.po;

import com.fengyu.common.entity.BaseEntity;

/**
 * 众筹项目收款人信息表
 *
 * @author Administrator
 * @create 2016 12 04 22:05
 */
public class OrderShipmentPO extends BaseEntity{
    private Integer prjtId;
    private String orderId;
    private String merchandiseType;
    private String merchandiseId;
    private String orderQuantity;
    private String orderRemark;

    public Integer getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(Integer prjtId) {
        this.prjtId = prjtId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMerchandiseType() {
        return merchandiseType;
    }

    public void setMerchandiseType(String merchandiseType) {
        this.merchandiseType = merchandiseType;
    }

    public String getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(String merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(String orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }
}
