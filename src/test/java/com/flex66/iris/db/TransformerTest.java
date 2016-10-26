package com.flex66.iris.db;

import com.flex66.iris.core.domainobject.UserComment;
import com.flex66.iris.db.domainobject.Comment;
import org.junit.Assert;
import org.junit.Test;

public class TransformerTest 
{
    @Test
    public void transform_Comment()
    {
        Comment comment = new Comment();
        UserComment userCommentExpected = new UserComment();
        
        Assert.assertEquals("Comment - UserComment transform worked", userCommentExpected, Transformer.transform(comment));
    }
    
    @Test
    public void transform_CommentNonEmpty()
    {
        Comment comment = new Comment(1, 10, "A comment");
        UserComment userCommentExpected = new UserComment(10, "A comment", 1);
        
        Assert.assertEquals("Comment - UserComment transform worked", userCommentExpected, Transformer.transform(comment));
    }
    
    @Test
    public void transform_CommentNull()
    {
        Assert.assertNull(Transformer.transform((Comment)null));
    }
    
    @Test
    public void transform_UserComment()
    {
        UserComment userComment = new UserComment();
        Comment expectedComment = new Comment();
        
        Assert.assertEquals("UserComment - Comment transform worked", expectedComment, Transformer.transform(userComment, 0));
    }
    
    @Test
    public void transform_UserCommentNonEmpty()
    {
        UserComment userComment = new UserComment(10, "A comment", 1);
        Comment commentExpected = new Comment(1, 10, "A comment");
        
        Assert.assertEquals("UserComment - Comment transform worked", commentExpected, Transformer.transform(userComment, 1));
    }
    
    @Test
    public void transform_UserCommentNull()
    {
        Assert.assertNull(Transformer.transform((UserComment)null, 0));
    }
}
