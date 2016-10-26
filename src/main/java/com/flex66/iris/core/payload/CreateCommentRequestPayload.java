package com.flex66.iris.core.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.flex66.iris.core.domainobject.UserComment;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.StringUtils;

@XmlRootElement
public class CreateCommentRequestPayload implements Validatable
{
    private UserComment comment;
    
    public CreateCommentRequestPayload()
    {
        this(null);
    }
    
    @JsonCreator
    public CreateCommentRequestPayload(UserComment comment)
    {
        this.comment = comment;
    }
    
    public UserComment getComment()
    {
        return comment;
    }

    @Override
    public void validate() 
    {
        if(comment == null || StringUtils.isBlank(comment.getText()))
        {
            throw new IllegalArgumentException("Create Comment Request is invalid");
        }
    }
}
