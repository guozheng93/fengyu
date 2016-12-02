package com.fengyu.web.util.session;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ApiSession {

	private String id;

	private Map<String, Object> attributesMap=new HashMap<String, Object>();
	private long lastAccessedAt;
	private long createdAt;
	private long maxIdle;
	
	public ApiSession(String key) {
		this.id=key;
		this.createdAt=this.lastAccessedAt=(new Date()).getTime();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getLastAccessedAt() {
		return lastAccessedAt;
	}
	public void setLastAccessedAt(long lastAccessedAt) {
		this.lastAccessedAt = lastAccessedAt;
	}
	public long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
	public long getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(long maxIdle) {
		this.maxIdle = maxIdle;
	}
	
	public void addAttribute(String name, Object value) {
		attributesMap.put(name, value);
	}
	
	public Object getAttribute(String name) {
		return attributesMap.get(name);
	}
	
	
}
