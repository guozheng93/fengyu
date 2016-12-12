package com.fengyu.common.exception.MapperSupport;

import com.alibaba.dubbo.common.json.JSON;
import com.fengyu.common.exception.Constant.ExceptionType;
import com.fengyu.common.exception.Constant.UserDefinedExceptionType;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * Created by admin on 2016/6/24.
 */
public class BaseException extends RuntimeException{


    public BaseException(Throwable ex){
        super(ex);
    }
    public BaseException(){};
    public void printLog(Throwable ex, ExceptionType exceptionType, Logger log, Object... args) {
        ex.printStackTrace();
        log.error("出现异常，异常自定义内容：编号["+exceptionType.getCode()+"],描述:["+exceptionType.getDesc()+"]");
        for (Object obj : args){
            try {
                log.error("执行参数："+ JSON.json(obj));
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        log.error("****************开始打印原始异常****************");
        log.error(ex.getMessage());
        log.error("****************原始异常打印结束****************");

    }


   /* public void printLog(Logger log)
    {

    }*/

}
