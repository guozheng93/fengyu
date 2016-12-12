package com.fengyu.common.exception.Constant;

/**
 * Created by admin on 2016/6/24.
 */
public enum UserDefinedExceptionType {

    METHODNOTFOUND("函数不存在","R0001");

    /** 描述 */
    private String desc;
    /** 枚举值 */
    private String code;

    private UserDefinedExceptionType(String desc,String code){
        this.desc = desc;
        this.code = code;
    }

    @Override
    public String toString() {
        return this.desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
