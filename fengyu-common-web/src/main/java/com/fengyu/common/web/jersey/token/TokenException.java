package com.fengyu.common.web.jersey.token;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/21
 */
public class TokenException extends WebApplicationException {
    private static final long serialVersionUID = 1L;

    public TokenException() {
        super(Response.status(401).entity("token异常").type(MediaType.TEXT_PLAIN)
                .build());
    }

    public TokenException(String msg) {
        super(Response.status(401).entity(msg).type(MediaType.TEXT_PLAIN)
                .build());
    }
}
