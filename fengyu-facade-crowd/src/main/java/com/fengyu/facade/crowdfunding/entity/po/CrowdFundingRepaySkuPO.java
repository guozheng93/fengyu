package com.fengyu.facade.crowdfunding.entity.po;

import com.fengyu.common.entity.BaseEntity;

/**
 * 回报商品库存以及价格表
 *
 * @author junz
 * @create 2016 12 04 21:44
 */
public class CrowdFundingRepaySkuPO extends BaseEntity{
    private Integer repayId;
    private String properties;
    private Integer quantity;
    private Double price;
    private String deliveryTime;

    public Integer getRepayId() {
        return repayId;
    }

    public void setRepayId(Integer repayId) {
        this.repayId = repayId;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
