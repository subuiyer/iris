package com.flex66.iris.core.domainobject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserComment 
{

    private int authorId;
    private int itemId;
    private String text;
    
    public UserComment()
    {
        this(0, null);
    }
    
    @JsonCreator
    public UserComment(@JsonProperty("itemId")int itemId, @JsonProperty("text")String text)
    {
        this(itemId, text, 0);
    }
    
    public UserComment(int itemId, String text, int authorId)
    {
        this.itemId = itemId;
        this.text = text;
        this.authorId = authorId;
    }
    
    public int getItemId()
    {
        return itemId;
    }
    
    public String getText()
    {
        return text;
    }
    
    public int getAuthorId()
    {
        return authorId;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null || !(obj instanceof UserComment))
        {
            return false;
        }
        if(obj == this)
        {
            return true;
        }
        UserComment commentObj = (UserComment)obj;
        return (commentObj.getAuthorId() == authorId
                && commentObj.getItemId() == itemId 
                && ((commentObj.getText() == null && text == null) || 
                    (commentObj.getText() != null && commentObj.getText().equals(text))));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.authorId;
        hash = 59 * hash + this.itemId;
        hash = 59 * hash + Objects.hashCode(this.text);
        return hash;
    }
    
}
