package com.flex66.iris.core.payload;


public class CreateCommentResponsePayload extends ResponsePayload
{
    private long commentId;
    

    public CreateCommentResponsePayload(long commentId)
    {
        this.commentId = commentId;
    }
    
    public long getCommentId()
    {
        return commentId;
    }
    
}
