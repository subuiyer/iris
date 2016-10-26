package com.flex66.iris.core.payload;

import com.flex66.iris.core.domainobject.UserComment;
import java.util.List;



public class GetCommentsResponsePayload extends ResponsePayload
{
    
    private final List<UserComment> comments;
    
    
    public GetCommentsResponsePayload(List<UserComment> comments)
    {
        this.comments = comments;
    }
    
    
    public List<UserComment> getComments()
    {
        return comments;
    }
}
