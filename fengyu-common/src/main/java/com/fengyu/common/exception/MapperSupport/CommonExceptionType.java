package com.fengyu.common.exception.MapperSupport;

import com.fengyu.common.exception.Constant.ExceptionType;

/**
 * 项目异常类型枚举
 *
 * @author Administrator
 * @create 2016 12 08 21:29
 */
public enum CommonExceptionType implements ExceptionType {
    METHODNOTFOUND("函数不存在","C0001"),
    SERVICEEXECUTE("SERVICE执行异常","C0002"),
    UPLOADINVALIDIMG("图片上传失败！","C0003"),
    JEDISOPRATOREXCEPTION("操作redis异常","C0004"),

    XMLRESOLVEEXCEPTION("xml解析异常","C0005"),
    UNKNOWNEXCEPTION("系统异常,未知异常请联系管理员","C0006"),

    FORBIDDEN("认证失败，请重新登录","C0007"),

    UNAUTHORIZED("登录失效，请重新登录","C0008");

    /** 描述 */
    private String desc;
    /** 枚举值 */
    private String code;

    private CommonExceptionType(String desc, String code){
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
