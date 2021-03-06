package com.fengyu.facade.crowdfunding.exception;

import com.fengyu.common.exception.Constant.ExceptionType;
import com.fengyu.common.exception.MapperSupport.BaseException;
import org.apache.log4j.Logger;

/**
 * 封装处理众筹项目模块异常
 *
 * @author junz
 * @create 2016 12 08 21:09
 */
public class CrowdExceptionHandler extends BaseException{
    Logger log = Logger.getLogger(CrowdExceptionHandler.class);

    public CrowdExceptionHandler(Throwable ex) {
        super(ex);
    }

    public CrowdExceptionHandler(Throwable ex, ExceptionType exceptionType, Object... args) {
        printLog(ex,exceptionType,this.log,args);
    }

    public static void main(String[] args) {
        Logger log = Logger.getLogger(CrowdExceptionHandler.class);
        log.debug("11211");
        log.error("1111");
    }

}
