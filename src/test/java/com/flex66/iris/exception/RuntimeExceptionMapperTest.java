/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flex66.iris.exception;

import com.flex66.iris.core.payload.ErrorMessageResponsePayload;
import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Subu
 */
public class RuntimeExceptionMapperTest 
{
    
    @Test
    public void toResponse()
    {
        String expectedMessage = "That was unexpected...";
        RuntimeExceptionMapper mapper = new RuntimeExceptionMapper();
        Response response = mapper.toResponse(new NullPointerException(expectedMessage));
        ErrorMessageResponsePayload payload = (ErrorMessageResponsePayload)response.getEntity();
    
        Assert.assertEquals("Response status is right", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
        Assert.assertEquals("Response message is right", expectedMessage, payload.getErrorMessage());
    }
}
