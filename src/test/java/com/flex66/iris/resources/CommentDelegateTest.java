package com.flex66.iris.resources;

import com.flex66.iris.core.domainobject.UserComment;
import com.flex66.iris.core.payload.CreateCommentRequestPayload;
import com.flex66.iris.db.Transformer;
import com.flex66.iris.db.dao.CommentsDao;
import com.flex66.iris.db.domainobject.Comment;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class CommentDelegateTest 
{
    
    @Test(expected = IllegalArgumentException.class)
    public void getComments_invalidItemId()
    {
        CommentDelegate delegate = new CommentDelegate(null);
        delegate.getComments(-1);
    }
    
    @Test(expected = RuntimeException.class)
    public void getComments_null()
    {
        CommentsDao dao = Mockito.mock(CommentsDao.class);
        Mockito.when(dao.findByItem(10)).thenReturn(null);
        CommentDelegate delegate = new CommentDelegate(dao);
        delegate.getComments(10);
    }
    
    @Test
    public void getComments()
    {
        List<Comment> listComments = new ArrayList<>();
        listComments.add(new Comment(1, 10, "abc"));
        listComments.add(new Comment(2, 20, "xyz"));
        
        CommentsDao dao = Mockito.mock(CommentsDao.class);
        Mockito.when(dao.findByItem(10)).thenReturn(listComments);
        CommentDelegate delegate = new CommentDelegate(dao);
        List<UserComment> listUserComments = delegate.getComments(10);
        
        Assert.assertNotNull(listUserComments);
        Assert.assertEquals("List contains the right size", 2, listUserComments.size());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createComment_invalidAuthorId()
    {
        CommentDelegate delegate = new CommentDelegate(null);
        delegate.createComment(0, new CreateCommentRequestPayload());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createComment_invalidAuthorId2()
    {
        CommentDelegate delegate = new CommentDelegate(null);
        delegate.createComment(-1, new CreateCommentRequestPayload());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createComment_invalidPayload()
    {
        CommentDelegate delegate = new CommentDelegate(null);
        delegate.createComment(10, null);
    }
    
    @Test
    public void createComment()
    {
        UserComment userComment = new UserComment(1, "abc");
        Comment comment = Transformer.transform(userComment, 99);
        CommentsDao dao = Mockito.mock(CommentsDao.class);
        Mockito.when(dao.upsert(comment)).thenReturn(100L);
        CommentDelegate delegate = new CommentDelegate(dao);
        
        Assert.assertEquals("Comment Id was returned as expected", 
                100L, delegate.createComment(99, new CreateCommentRequestPayload(
                                new UserComment(1, "abc"))));
    }
}
