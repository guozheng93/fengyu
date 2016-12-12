package com.fengyu.common.entity;

import com.fengyu.common.page.PageBean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @描述: 基础实体类，包含各实体公用属性 .
 * @版本: 1.0 .
 */
public class VOEntity extends PageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer version = 0;
	/**
	 * 创建时间
	 */
	protected Date createTime = new Date();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
