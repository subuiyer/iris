package com.flex66.iris.core.payload;


import com.flex66.iris.core.domainobject.UserComment;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class GetCommentsResponsePayloadTest 
{
    @Test
    public void getComments_null()
    {
        GetCommentsResponsePayload payload = new GetCommentsResponsePayload(null);
        Assert.assertNull(payload.getComments());
    }
    
    @Test
    public void getComments()
    {
        List<UserComment> lst = new ArrayList<>();
        lst.add(new UserComment());
        lst.add(new UserComment());
        GetCommentsResponsePayload payload = new GetCommentsResponsePayload(lst);
        Assert.assertNotNull(payload.getComments());
        Assert.assertEquals("Number comments is right", 2, payload.getComments().size());
    }
}
