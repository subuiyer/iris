package com.flex66.iris.db;

import com.flex66.iris.core.domainobject.UserComment;
import com.flex66.iris.db.domainobject.Comment;

public class Transformer 
{
    
    public static Comment transform(UserComment userComment, int authorId)
    {
        if(userComment == null)
        {
            return null;
        }
        return new Comment(authorId, userComment.getItemId(), userComment.getText());
    }
    
    
    public static UserComment transform(Comment comment)
    {
        if(comment == null)
        {
            return null;
        }
        return new UserComment(comment.getItemId(), comment.getText(), comment.getAuthorId());
    }
}
