package com.flex66.iris.db.domainobject;

import org.junit.Test;
import org.junit.Assert;

public class CommentTest 
{

    @Test
    public void comment_cst()
    {
        Comment comment = new Comment(1, 10, "abc");
        
        Assert.assertTrue(comment.getAuthorId() == 1);
        Assert.assertTrue(comment.getItemId() == 10);
        Assert.assertTrue(comment.getId() == 0);
        Assert.assertTrue(comment.getText().equals("abc"));
    }
    
    @Test
    public void equals_true()
    {
        Comment comment1 = new Comment(1, 10, "abc");
        Comment comment2 = new Comment(1, 10, "abc");
        
        Assert.assertTrue(comment1.equals(comment2));
        Assert.assertTrue(comment1.hashCode() == comment2.hashCode());
        Assert.assertTrue(comment2.equals(comment1));
    }
    
    @Test
    public void equals_null()
    {
        Comment comment = new Comment();
        Assert.assertFalse(comment.equals(null));
        Assert.assertFalse(comment.equals("abc"));
    }
    
    @Test
    public void equals_sameObject()
    {
        Comment comment = new Comment();
        Assert.assertTrue(comment.equals(comment));
    }
    
    @Test
    public void equals_falseUnequalText()
    {
        Comment comment1 = new Comment(1, 10, "abc");
        Comment comment2 = new Comment(1, 10, "abc...");
        
        Assert.assertFalse(comment1.equals(comment2));
        Assert.assertFalse(comment1.hashCode() == comment2.hashCode());
    }
    
    @Test
    public void equals_trueNullText()
    {
        Comment comment1 = new Comment(1, 10, null);
        Comment comment2 = new Comment(1, 10, null);
        
        Assert.assertTrue(comment1.equals(comment2));
        Assert.assertTrue(comment1.hashCode() == comment2.hashCode());
    }
    
    @Test
    public void equals_falseOneNullText()
    {
        Comment comment1 = new Comment(1, 10, null);
        Comment comment2 = new Comment(1, 10, "aaa");
        
        Assert.assertFalse(comment1.equals(comment2));
        Assert.assertFalse(comment1.hashCode() == comment2.hashCode());
    }
    
    @Test
    public void equals_falseOneNullText2()
    {
        Comment comment1 = new Comment(1, 10, "aaa");
        Comment comment2 = new Comment(1, 10, null);
        
        Assert.assertFalse(comment1.equals(comment2));
        Assert.assertFalse(comment1.hashCode() == comment2.hashCode());
    }
    
    @Test
    public void equals_falseUnequalAuthor()
    {
        Comment comment1 = new Comment(1, 10, "abc");
        Comment comment2 = new Comment(11, 10, "abc");
        Assert.assertFalse(comment1.equals(comment2));
        Assert.assertFalse(comment1.hashCode() == comment2.hashCode());
    }
    
    @Test
    public void equals_falseUnequalItemId()
    {
        Comment comment1 = new Comment(1, 10, "abc");
        Comment comment2 = new Comment(1, 100, "abc");
        Assert.assertFalse(comment1.equals(comment2));
        Assert.assertFalse(comment1.hashCode() == comment2.hashCode());
    }
}
