package com.fengyu.facade.crowdfunding.entity.po;

import com.fengyu.common.entity.BaseEntity;

/**
 * 众筹项目基础bean
 *
 * @author junz
 * @create 2016 12 04 21:06
 */
public class CrowdFundingPublicityImgPO extends BaseEntity{
    private Integer publicityId;
    private String publicityImage;

    public Integer getPublicityId() {
        return publicityId;
    }

    public void setPublicityId(Integer publicityId) {
        this.publicityId = publicityId;
    }

    public String getPublicityImage() {
        return publicityImage;
    }

    public void setPublicityImage(String publicityImage) {
        this.publicityImage = publicityImage;
    }
}
