package com.fengyu.facade.crowdfunding.entity.po;

import com.fengyu.common.entity.BaseEntity;

/**
 * 产品众筹规格特征值
 *
 * @author Administrator
 * @create 2016 12 04 21:52
 */
public class CrowdfundingItemPropValuePO extends BaseEntity{
    private String propValueName;
    private Integer propId;

    public String getPropValueName() {
        return propValueName;
    }

    public void setPropValueName(String propValueName) {
        this.propValueName = propValueName;
    }

    public Integer getPropId() {
        return propId;
    }

    public void setPropId(Integer propId) {
        this.propId = propId;
    }
}
