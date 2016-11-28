package com.fengyu.common.config;


import com.fengyu.common.utils.ResourceUtils;

import java.util.Map;


/**
 * className：PublicConifg <br>
 * Function： 环境配置基础类 <br>
 * 
 * @author laich
 */
public class PublicConfig {

	/**
	 * 用户文件配置 加载。
	 */
	public static Map<String, String> PUBLIC_USER = ResourceUtils.getResource("public_user").getMap();

	/**
	 * 系统文件配置 加载。
	 */
	public static Map<String, String> PUBLIC_SYSTEM = ResourceUtils.getResource("public_system").getMap();



}
