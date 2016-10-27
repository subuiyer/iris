package com.flex66.iris.exception;

import com.flex66.iris.core.payload.ErrorMessageResponsePayload;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException>
{

    private static final Logger logger = LoggerFactory.getLogger(RuntimeExceptionMapper.class);
    
    @Override
    public Response toResponse(RuntimeException e) 
    {
        logger.info("RuntimeException - {}", e.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
                new ErrorMessageResponsePayload(e.getMessage())).build();
    }
    
}
