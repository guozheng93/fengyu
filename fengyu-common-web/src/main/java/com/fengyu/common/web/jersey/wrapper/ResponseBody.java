package com.fengyu.common.web.jersey.wrapper;

import com.fengyu.common.entity.VOEntity;

import java.util.List;

/**
 * 返回对象统一封装类
 *
 * @author junz
 * @create 2016 12 04 19:34
 */
public class ResponseBody {
    private Integer count=0;
    private List<VOEntity> VOEntity;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<com.fengyu.common.entity.VOEntity> getVOEntity() {
        return VOEntity;
    }

    public void setVOEntity(List<com.fengyu.common.entity.VOEntity> VOEntity) {
        this.VOEntity = VOEntity;
    }
}
