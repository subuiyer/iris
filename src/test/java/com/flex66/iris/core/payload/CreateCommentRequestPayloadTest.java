package com.flex66.iris.core.payload;


import com.flex66.iris.core.domainobject.UserComment;
import org.junit.Assert;
import org.junit.Test;

public class CreateCommentRequestPayloadTest 
{
    
    @Test
    public void getComment()
    {
        CreateCommentRequestPayload payload = new CreateCommentRequestPayload();
        Assert.assertNull(payload.getComment());
        
        payload = new CreateCommentRequestPayload(new UserComment());
        Assert.assertNotNull(payload.getComment());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void validate_nullComment()
    {
        CreateCommentRequestPayload payload = new CreateCommentRequestPayload();
        payload.validate();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void validate_nullCommentText()
    {
        CreateCommentRequestPayload payload = new CreateCommentRequestPayload(
            new UserComment(1, null, 10));
        payload.validate();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void validate_blankCommentText()
    {
        CreateCommentRequestPayload payload = new CreateCommentRequestPayload(
            new UserComment(1, "", 10));
        payload.validate();
    }
    
}
