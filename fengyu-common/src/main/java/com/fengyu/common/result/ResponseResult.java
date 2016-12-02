package com.fengyu.common.result;


import com.fengyu.common.enums.ErrorEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应结果
 * @author chendy
 *
 */
public class ResponseResult {
	private String status = STATUS_OK;//状态
	private String errorCode = "0";//错误代码
	private String msg = "";//提示信息
	private Object info;//业务数据
	private String token;//会话令牌
	private int sumCount;//获取验证码次数
	
	public static final String STATUS_OK = "1";
	public static final String STATUS_ERR = "0";
	private static final String TOTAL_COUNT = "totalCount";
	private static final String PAGE_DATA = "listItems";
	public static final String PARAM_PAGE_SIZE = "pageSize";


	public int getSumCount() {
		return sumCount;
	}

	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * 设置错误信息
	 * @param error
	 */
	public void setError(ErrorEnum error){
		setError(error,error.getMsg());
	}
	
	/**
	 * 设置错误信息：使用自定义的提示
	 * @param error
	 * @param msg
	 */
	public void setError(ErrorEnum error,String msg){
		setStatus(STATUS_ERR);
		setErrorCode(error.getErrCode());
		setMsg(msg);
	}
	
	/**
	 * 设置分页数据
	 * @param count
	 * @param data
	 */
	public void setPageData(int count, List<?> data,Map<String, Object> paraMap){
		if(count == 0){
			data = new ArrayList<Object>(0);
		}
		
		Map<String,Object> pageData = new HashMap<String,Object>();
		pageData.put(TOTAL_COUNT, count);
		pageData.put(PAGE_DATA, data);
		pageData.put(PARAM_PAGE_SIZE, paraMap.get(PARAM_PAGE_SIZE));
		setInfo(pageData);
	}
}