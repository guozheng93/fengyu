package com.fengyu.common.enums;

/**
 * 系统错误 ：错误代码及对应的提示信息
 * @author Admin
 *
 */
public enum ErrorEnum {
	QUERY_ERR("500","查询错误"),
	TOKEN_TIMEOUT("200","登陆令牌失效，请重新登陆！"),
	PARAM_ERR("101","参数错误"),
	SAVE_ERR("600","保存出错"),
	DEL_ERR("700","删除出错"),
	SEND_ERR("102","发送信息失败");
	
	private String errCode;//错误代码
	private String msg;//错误提示
	
	private ErrorEnum(String errCode, String msg){
		this.errCode = errCode;
		this.msg = msg;
	}
	public String getErrCode() {
		return errCode;
	}
	public String getMsg() {
		return msg;
	}
	
}
