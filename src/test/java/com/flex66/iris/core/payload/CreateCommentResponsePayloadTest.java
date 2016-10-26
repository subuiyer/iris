package com.flex66.iris.core.payload;


import org.junit.Assert;
import org.junit.Test;

public class CreateCommentResponsePayloadTest 
{

    @Test
    public void getCommentId()
    {
       CreateCommentResponsePayload payload = new CreateCommentResponsePayload(9);
       Assert.assertEquals("Payload Id is as expected", 9, payload.getCommentId());
    }
    
}
