package com.fengyu.facade.crowdfunding.entity.vo;

import com.fengyu.common.entity.BaseEntity;
import com.fengyu.common.entity.VOEntity;

import java.util.List;

/**
 * 众筹产品规格特征量
 *
 * @author Administrator
 * @create 2016 12 04 21:48
 */
public class CrowdfundingItemPropsVO extends VOEntity {

    private Integer repayId;
    private String  propName;
    private Integer itemId;
    private Integer pPropId;
    private Integer prjtId;
    private Integer status;
    private List<CrowdfundingItemPropValueVO> propValues;

    public List<CrowdfundingItemPropValueVO> getPropValues() {
        return propValues;
    }

    public void setPropValues(List<CrowdfundingItemPropValueVO> propValues) {
        this.propValues = propValues;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRepayId() {
        return repayId;
    }

    public void setRepayId(Integer repayId) {
        this.repayId = repayId;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getpPropId() {
        return pPropId;
    }

    public void setpPropId(Integer pPropId) {
        this.pPropId = pPropId;
    }

    public Integer getPrjtId() {
        return prjtId;
    }

    public void setPrjtId(Integer prjtId) {
        this.prjtId = prjtId;
    }
}
