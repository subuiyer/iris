package com.flex66.iris.core.domainobject;

import org.junit.Assert;
import org.junit.Test;

public class UserCommentTest 
{
    
    @Test
    public void getText()
    {
       UserComment comment = new UserComment();
       Assert.assertNull("Comment text is null", comment.getText());
       
       String expectedText = "This is a comment";
       comment = new UserComment(1, expectedText);
       Assert.assertEquals("Comment text is as expected", expectedText, comment.getText());
    }
    
    @Test
    public void getItemId()
    {
       UserComment comment = new UserComment();
       Assert.assertEquals("Comment ItemId is not set", 0, comment.getItemId());
       
       comment = new UserComment(10, "blah");
       Assert.assertEquals("Comment ItemId is as expected", 10, comment.getItemId());
    }
    
    @Test
    public void getAuthorId()
    {
       UserComment comment = new UserComment();
       Assert.assertEquals("Comment AuthorId is not set", 0, comment.getItemId());
       
       comment = new UserComment(10, "blah", 20);
       Assert.assertEquals("Comment AuthorId is as expected", 20, comment.getAuthorId());
    }
    
    @Test
    public void equals_null()
    {
        UserComment comment = new UserComment();
        Assert.assertFalse(comment.equals(null));
        Assert.assertFalse(comment.equals("abc"));
    }
    
    @Test
    public void equals_sameObject()
    {
        UserComment comment = new UserComment();
        Assert.assertTrue(comment.equals(comment));
    }
    
    @Test
    public void equals_true()
    {
        UserComment comment1 = new UserComment(1, "this is a test", 2);
        UserComment comment2 = new UserComment(1, "this is a test", 2);
        Assert.assertTrue(comment1.equals(comment2) && comment2.equals(comment1));
        Assert.assertTrue(comment1.hashCode() == comment2.hashCode());
    }
    
    @Test
    public void equals_falseUnequalText()
    {
        UserComment comment1 = new UserComment(1, "this is a test", 2);
        UserComment comment2 = new UserComment(1, "this is not a test", 2);
        Assert.assertFalse(comment1.equals(comment2));
        Assert.assertFalse(comment1.hashCode() == comment2.hashCode());
    }
    
    @Test
    public void equals_falseUnequalAuthor()
    {
        UserComment comment1 = new UserComment(1, "this is a test", 2);
        UserComment comment2 = new UserComment(1, "this is a test", 20);
        Assert.assertFalse(comment1.equals(comment2));
        Assert.assertFalse(comment1.hashCode() == comment2.hashCode());
    }
    
    @Test
    public void equals_falseUnequalItem()
    {
        UserComment comment1 = new UserComment(1, "this is a test", 2);
        UserComment comment2 = new UserComment(10, "this is a test", 2);
        Assert.assertFalse(comment1.equals(comment2));
        Assert.assertFalse(comment1.hashCode() == comment2.hashCode());
    }
    
    @Test
    public void equals_trueNullText()
    {
        UserComment comment1 = new UserComment(1, null, 2);
        UserComment comment2 = new UserComment(1, null, 2);
        Assert.assertTrue(comment1.equals(comment2));
        Assert.assertTrue(comment1.hashCode() == comment2.hashCode());
    }
    
    @Test
    public void equals_falseNullText()
    {
        UserComment comment1 = new UserComment(1, null, 2);
        UserComment comment2 = new UserComment(1, "not null", 2);
        Assert.assertFalse(comment1.equals(comment2));
        Assert.assertFalse(comment1.hashCode() == comment2.hashCode());
    }
    
    @Test
    public void equals_falseNullText2()
    {
        UserComment comment1 = new UserComment(1, "not null", 2);
        UserComment comment2 = new UserComment(1, null, 2);
        Assert.assertFalse(comment1.equals(comment2));
        Assert.assertFalse(comment1.hashCode() == comment2.hashCode());
    }
    
}
