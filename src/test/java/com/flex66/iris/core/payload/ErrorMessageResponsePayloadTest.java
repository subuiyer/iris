package com.flex66.iris.core.payload;

import org.junit.Assert;
import org.junit.Test;

public class ErrorMessageResponsePayloadTest 
{
    @Test
    public void getErrorMessage()
    {
        String expectedMessage = "Invalid args";
        ErrorMessageResponsePayload payload = new ErrorMessageResponsePayload(expectedMessage);
        Assert.assertEquals("Error message is correct", expectedMessage, payload.getErrorMessage());
    }
    
}
