package com.flex66.iris.exception;


import com.flex66.iris.core.payload.ErrorMessageResponsePayload;
import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Test;


public class IllegalArgumentExceptionMapperTest 
{
    
    @Test
    public void toResponse()
    {
        String expectedMessage = "Bad stuff!";
        IllegalArgumentExceptionMapper mapper = new IllegalArgumentExceptionMapper();
        Response response = mapper.toResponse(new IllegalArgumentException(expectedMessage));
        ErrorMessageResponsePayload payload = (ErrorMessageResponsePayload)response.getEntity();
    
        Assert.assertEquals("Response status is right", Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
        Assert.assertEquals("Response message is right", expectedMessage, payload.getErrorMessage());
    }
}
