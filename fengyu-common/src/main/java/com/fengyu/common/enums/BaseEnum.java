package com.fengyu.common.enums;

/**
 * 枚举属性基础类
 *
 * @author junz
 * @create 2016 12 09 17:43
 */
public interface BaseEnum {
    /** 描述 */
    public String desc="";
    /** 枚举值 */
    public String code = "";
    public String getDesc();

    public void setDesc(String desc);

    public String getCode();

    public void setCode(String code);
}
