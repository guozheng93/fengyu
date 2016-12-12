package com.fengyu.facade.crowdfunding.entity.po;

import com.fengyu.common.entity.BaseEntity;

/**
 * 项目详情Bean
 *
 * @author junz
 * @create 2016 12 04 21:17
 */
public class CrowdFundingDetailPO extends BaseEntity {
    private String prjtDetail;

    public String getPrjtDetail() {
        return prjtDetail;
    }

    public void setPrjtDetail(String prjtDetail) {
        this.prjtDetail = prjtDetail;
    }
}
