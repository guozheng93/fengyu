package com.fengyu.facade.user.login.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum UserTypeEnum {

	
	/** 超级管理员 **/
	SUPER_ADMIN("超级管理员", "1"),
	
	/** 普通管理员 **/
	ADMIN("普通管理员", "2"),

	/** 用户主帐号（商家主帐号） **/
	MEM_USER("用户主帐号", "3");

	/** 描述 */
	private String desc;
	/** 枚举值 */
	private String value;

	private UserTypeEnum(String desc, String value) {
		this.desc = desc;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static UserTypeEnum getEnum(String value){
		UserTypeEnum resultEnum = null;
		UserTypeEnum[] enumAry = UserTypeEnum.values();
		for(int i = 0;i<enumAry.length;i++){
			if(enumAry[i].getValue().equals(value)){
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}
	
	public static Map<String, Map<String, Object>> toMap() {
		UserTypeEnum[] ary = UserTypeEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = String.valueOf(getEnum(ary[num].getValue()));
			map.put("value", ary[num].getValue());
			map.put("desc", ary[num].getDesc());
			enumMap.put(key, map);
		}
		return enumMap;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toList(){
		UserTypeEnum[] ary = UserTypeEnum.values();
		List list = new ArrayList();
		for(int i=0;i<ary.length;i++){
			Map<String,String> map = new HashMap<String,String>();
			map.put("value",ary[i].getValue());
			map.put("desc", ary[i].getDesc());
			list.add(map);
		}
		return list;
	}

}
