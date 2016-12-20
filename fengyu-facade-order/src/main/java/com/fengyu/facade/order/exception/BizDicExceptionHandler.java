package com.fengyu.facade.order.exception;

import com.fengyu.common.exception.Constant.ExceptionType;
import com.fengyu.common.exception.MapperSupport.BaseException;
import org.apache.log4j.Logger;

/**
 * 封装处理众筹项目模块异常
 *
 * @author junz
 * @create 2016 12 08 21:09
 */
public class BizDicExceptionHandler extends BaseException{
    Logger log = Logger.getLogger(BizDicExceptionHandler.class);

    public BizDicExceptionHandler(Throwable ex) {
        super(ex);
    }

    public BizDicExceptionHandler(Throwable ex, ExceptionType exceptionType, Object... args) {
        printLog(ex,exceptionType,this.log,args);
    }

    public static void main(String[] args) {
        Logger log = Logger.getLogger(BizDicExceptionHandler.class);
        log.debug("11211");
        log.error("1111");
    }

}
