package com.fengyu.facade.crowdfunding.entity.vo;

import com.fengyu.common.entity.BaseEntity;
import com.fengyu.common.entity.VOEntity;

/**
 * 众筹项目基础bean
 *
 * @author junz
 * @create 2016 12 04 21:06
 */
public class CrowdFundingPublicityImgVO extends VOEntity{
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
