package com.flex66.iris.core.payload;

import org.junit.Assert;
import org.junit.Test;


public class ResponsePayloadTest 
{
    
    @Test
    public void setErrorMessage()
    {
       ResponsePayload payload = new ResponsePayload();
       String expectedErrorMessge = "Bad stuff!";
       payload.setErrorMessage(expectedErrorMessge);
       Assert.assertEquals("Error message is as expected", expectedErrorMessge, payload.getErrorMessage());
    }
    
    @Test
    public void setErrorMessage_notSet()
    {
       ResponsePayload payload = new ResponsePayload();
       Assert.assertNull(payload.getErrorMessage());
    }
    
}
