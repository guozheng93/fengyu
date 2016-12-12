package com.fengyu.facade.crowdfunding.entity.vo;


public class CrowdFundingEntityVO extends CrowdFundingVO {
    private String entityCoverImage;
    private String entityCatalogImage;
    private String entityLocationProvince;
    private String entityLocationPity;
    private String entityLocationCounty;
    private String entityLocationFull;
    private Integer acctId;

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }

    public String getEntityCoverImage() {
        return entityCoverImage;
    }

    public void setEntityCoverImage(String entityCoverImage) {
        this.entityCoverImage = entityCoverImage;
    }

    public String getEntityCatalogImage() {
        return entityCatalogImage;
    }

    public void setEntityCatalogImage(String entityCatalogImage) {
        this.entityCatalogImage = entityCatalogImage;
    }

    public String getEntityLocationProvince() {
        return entityLocationProvince;
    }

    public void setEntityLocationProvince(String entityLocationProvince) {
        this.entityLocationProvince = entityLocationProvince;
    }

    public String getEntityLocationPity() {
        return entityLocationPity;
    }

    public void setEntityLocationPity(String entityLocationPity) {
        this.entityLocationPity = entityLocationPity;
    }

    public String getEntityLocationCounty() {
        return entityLocationCounty;
    }

    public void setEntityLocationCounty(String entityLocationCounty) {
        this.entityLocationCounty = entityLocationCounty;
    }

    public String getEntityLocationFull() {
        return entityLocationFull;
    }

    public void setEntityLocationFull(String entityLocationFull) {
        this.entityLocationFull = entityLocationFull;
    }
}
