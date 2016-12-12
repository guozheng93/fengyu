package com.fengyu.facade.crowdfunding.entity.vo;

import com.fengyu.common.entity.BaseEntity;
import com.fengyu.common.entity.VOEntity;

/**
 * 项目详情Bean
 *
 * @author junz
 * @create 2016 12 04 21:17
 */
public class CrowdFundingDetailVO extends VOEntity {
    private String prjtDetail;

    public String getPrjtDetail() {
        return prjtDetail;
    }

    public void setPrjtDetail(String prjtDetail) {
        this.prjtDetail = prjtDetail;
    }
}
