package com.flex66.iris.exception;

import com.flex66.iris.core.payload.ErrorMessageResponsePayload;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException>
{

    private static final Logger logger = LoggerFactory.getLogger(IllegalArgumentExceptionMapper.class);
    
    @Override
    public Response toResponse(IllegalArgumentException e) 
    {
        logger.info("Invalid parameters. {}", e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(
                new ErrorMessageResponsePayload(e.getMessage())).build();
    }
    
}
