package com.fengyu.facade.other.area.entity.po;

import java.io.Serializable;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/25
 */
public class AreaPO implements Serializable {

    private String id;
    private String name;
    private String parentid;
    private int level;
    private int  orderby;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOrderby() {
        return orderby;
    }

    public void setOrderby(int orderby) {
        this.orderby = orderby;
    }
}
