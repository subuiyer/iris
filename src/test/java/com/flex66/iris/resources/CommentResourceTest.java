package com.flex66.iris.resources;

import com.flex66.iris.core.domainobject.UserComment;
import com.flex66.iris.core.payload.CreateCommentRequestPayload;
import com.flex66.iris.core.payload.CreateCommentResponsePayload;
import com.flex66.iris.core.payload.GetCommentsResponsePayload;
import com.flex66.iris.db.domainobject.Comment;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;

public class CommentResourceTest 
{

    @Test
    public void createComment()
    {
        CreateCommentRequestPayload payload = new CreateCommentRequestPayload();
        CommentDelegate delegate = Mockito.mock(CommentDelegate.class);
        Mockito.when(delegate.createComment(1, payload)).thenReturn(9L);
        CommentResource resource = new CommentResource(delegate);
        Response response = resource.createComment(1, payload);
        
        Assert.assertNotNull(response);
        Assert.assertEquals("Response Status is right", Response.Status.OK.getStatusCode(), response.getStatus());
        Assert.assertEquals("Response is right", 9L, ((CreateCommentResponsePayload)response.getEntity()).getCommentId());
    }
    
    @Test
    public void getComments()
    {
        List<UserComment> listComments = new ArrayList<>();
        listComments.add(new UserComment(1, "abc", 10));
        listComments.add(new UserComment(1, "xyz", 10));
        CommentDelegate delegate = Mockito.mock(CommentDelegate.class);
        Mockito.when(delegate.getComments(1)).thenReturn(listComments);
        CommentResource resource = new CommentResource(delegate);
        Response response = resource.getComments(1);
        
        Assert.assertNotNull(response);
        Assert.assertEquals("Response Status is right", Response.Status.OK.getStatusCode(), response.getStatus());
        Assert.assertEquals("Response is right", 2, ((GetCommentsResponsePayload)response.getEntity()).getComments().size());
    }
}
