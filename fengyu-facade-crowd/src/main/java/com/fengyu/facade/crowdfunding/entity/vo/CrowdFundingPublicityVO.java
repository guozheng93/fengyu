package com.fengyu.facade.crowdfunding.entity.vo;

import com.fengyu.common.entity.BaseEntity;
import com.fengyu.common.entity.VOEntity;

import java.util.List;

/**
 * 众筹项目基础bean
 *
 * @author junz
 * @create 2016 12 04 21:06
 */
public class CrowdFundingPublicityVO extends VOEntity{
    private Integer prjtId;
    private String author;
    private String message;
    private String publicityTime;
    private List<CrowdFundingPublicityImgVO> publicityImgs;

    public Integer getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(Integer prjtId) {
        this.prjtId = prjtId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPublicityTime() {
        return publicityTime;
    }

    public void setPublicityTime(String publicityTime) {
        this.publicityTime = publicityTime;
    }

    public List<CrowdFundingPublicityImgVO> getPublicityImgs() {
        return publicityImgs;
    }

    public void setPublicityImgs(List<CrowdFundingPublicityImgVO> publicityImgs) {
        this.publicityImgs = publicityImgs;
    }
}
