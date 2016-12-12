package com.fengyu.common.exception.MapperSupport;

import com.fengyu.common.exception.Constant.UserDefinedExceptionType;
import org.springframework.http.HttpStatus;

public class WebActionException extends AbstractException {
    protected UserDefinedExceptionType type;
    protected Object data;
    protected HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }


    public WebActionException(Throwable ex, UserDefinedExceptionType type, Object data){
        super(ex);
        this.type = type;
        this.data = data;
    }
    public WebActionException(HttpStatus httpStatus, Throwable ex, UserDefinedExceptionType type, Object data)
    {
        super(ex);
        this.httpStatus=httpStatus;
        this.type = type;
        this.data = data;
    }


    public WebActionException(UserDefinedExceptionType type, Object data){
        this(HttpStatus.INTERNAL_SERVER_ERROR,null,type,data);
    }
    @Override
    public UserDefinedExceptionType getUserDefindExType(){
        return this.type;
    }
    public  Object getData(){
        return  this.data;
    }

    public static void main(String[] args) {
        System.out.println(HttpStatus.EXPECTATION_FAILED.value());
    }

}
