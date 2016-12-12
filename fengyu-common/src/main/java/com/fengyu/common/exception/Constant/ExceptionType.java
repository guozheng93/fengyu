package com.fengyu.common.exception.Constant;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2016 12 08 21:50
 */
public interface ExceptionType {
    /** 描述 */
    public String desc="";
    /** 枚举值 */
    public String code = "";
    public String getDesc();

    public void setDesc(String desc);

    public String getCode();

    public void setCode(String code);
}
