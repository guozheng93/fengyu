package com.fengyu.common.exception.MapperSupport;

import org.apache.log4j.Logger;

/**
 * 封装处理众筹项目模块异常
 *
 * @author junz
 * @create 2016 12 08 21:09
 */
public class CommonExceptionHandler extends BaseException{
    Logger log = Logger.getLogger(CommonExceptionHandler.class);

    public CommonExceptionHandler(Throwable ex) {
        super(ex);
    }

    public CommonExceptionHandler(Throwable ex, CommonExceptionType exceptionType, Object... args) {
        printLog(ex,exceptionType,this.log,args);
    }

    public static void main(String[] args) {
        Logger log = Logger.getLogger(CommonExceptionHandler.class);
        log.debug("11211");
        log.error("1111");
    }

}
