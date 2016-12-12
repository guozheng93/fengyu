package com.fengyu.common.exception.MapperSupport;

import com.fengyu.common.exception.Constant.UserDefinedExceptionType;
import org.springframework.http.HttpStatus;

/**
 * Created by admin on 2016/6/24.
 */
public abstract class AbstractException extends RuntimeException{


    public AbstractException(Throwable ex){
        super(ex);
    }



    public abstract UserDefinedExceptionType getUserDefindExType();
    public abstract HttpStatus getHttpStatus();

}
