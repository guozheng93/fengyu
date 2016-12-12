package com.fengyu.facade.crowdfunding.exception;

import com.fengyu.common.exception.Constant.ExceptionType;

/**
 * 项目异常类型枚举
 *
 * @author Administrator
 * @create 2016 12 08 21:29
 */
public enum  CrowdExceptionType implements ExceptionType {
    METHODNOTFOUND("函数不存在","R0001");

    /** 描述 */
    private String desc;
    /** 枚举值 */
    private String code;

    private CrowdExceptionType(String desc,String code){
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
