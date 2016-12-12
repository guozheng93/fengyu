package com.fengyu.facade.crowdfunding.entity.vo;

import com.fengyu.common.entity.BaseEntity;
import com.fengyu.common.entity.VOEntity;

public class CrowdFundingItemVO extends VOEntity {
    //类目名称
    private  String itemName;
    //父级类目id
    private Integer pItemId;
    //是否为为父级类目 0 不是 1是
    private Integer isPItemId;
    //类目排序
    private Integer sortSeq;
    //父级类目名称
    private String pItemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getpItemId() {
        return pItemId;
    }

    public void setpItemId(Integer pItemId) {
        this.pItemId = pItemId;
    }

    public Integer getIsPItemId() {
        return isPItemId;
    }

    public void setIsPItemId(Integer isPItemId) {
        this.isPItemId = isPItemId;
    }

    public Integer getSortSeq() {
        return sortSeq;
    }

    public void setSortSeq(Integer sortSeq) {
        this.sortSeq = sortSeq;
    }

    public String getpItemName() {
        return pItemName;
    }

    public void setpItemName(String pItemName) {
        this.pItemName = pItemName;
    }
}
