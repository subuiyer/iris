package com.flex66.iris.resources;

import com.flex66.iris.core.domainobject.UserComment;
import com.flex66.iris.core.payload.CreateCommentRequestPayload;
import com.flex66.iris.db.Transformer;
import com.flex66.iris.db.dao.CommentsDao;
import com.flex66.iris.db.domainobject.Comment;
import java.util.ArrayList;
import java.util.List;

public class CommentDelegate 
{
    
    private CommentsDao commentsDao;
    
    public CommentDelegate(CommentsDao dao)
    {
        commentsDao = dao;
    }
    
    
    public long createComment(int authorId, CreateCommentRequestPayload commentRequest)
    {
        if(authorId <= 0 || commentRequest == null)
        {
            throw new IllegalArgumentException("Missing parameters for Create Comment");
        }
        commentRequest.validate();
        return commentsDao.upsert(Transformer.transform(commentRequest.getComment(), authorId));
    }
    
    
    public List<UserComment> getComments(int itemId)
    {
        if(itemId < 0)
        {
            throw new IllegalArgumentException("Invalid itemId:" + itemId);
        }
        List<Comment> listComments = commentsDao.findByItem(itemId);
        if(listComments == null)
        {
            throw new RuntimeException("Retrieved a null comment list");
        }
        
        List<UserComment> listUserComments = new ArrayList<>();
        UserComment userComment;
        for(Comment comment : listComments)
        {
            userComment = Transformer.transform(comment);
            listUserComments.add(userComment);
        }
        
        return listUserComments;
    }
}
