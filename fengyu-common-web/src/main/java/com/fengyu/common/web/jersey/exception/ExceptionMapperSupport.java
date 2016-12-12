package com.fengyu.common.web.jersey.exception;

import com.fengyu.common.exception.Constant.BaseExceptionType;
import com.fengyu.common.exception.Constant.ExceptionType;
import com.fengyu.common.exception.MapperSupport.AbstractException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class ExceptionMapperSupport implements ExceptionMapper<Throwable>{
    private static final Logger logger = LoggerFactory.getLogger(ExceptionMapperSupport.class);

    @Override
    public Response toResponse(Throwable exception) {
        if(logger.isDebugEnabled())
        {
            exception.printStackTrace();
        }
        if(exception instanceof AbstractException) {
            AbstractException exception1 = (AbstractException) exception;
            return Response.status(exception1.getHttpStatus().value()).entity("[{message:\""+exception1.getUserDefindExType()+".\"}]").type("application/json").build();
        }
       // return Response.status(500).entity("{exceptionMsg:\""+exception1.getUserDefindExType()+".\"}").type("application/json").build();
        return Response.status(500).entity("[{message:程序异常}]").type("application/json").build();
    }
}

