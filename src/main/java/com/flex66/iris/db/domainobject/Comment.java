package com.flex66.iris.db.domainobject;

import com.flex66.iris.core.domainobject.UserComment;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name = "comments")
@NamedQueries({
    @NamedQuery(name = "com.flex66.iris.db.findByItem",
        query = "select c from Comment c" 
        + " where c.itemId=:id")
})
public class Comment 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "itemid")
    private int itemId;
    
    @Column(name = "authorid")
    private int authorId;
    
    @Column(name = "text")
    private String text;
    
    
    public Comment()
    {
        
    }
    
    public Comment(int authorId, int itemId, String text)
    {
        this.authorId = authorId;
        this.itemId = itemId;
        this.text = text;
    }
    
    
    public long getId()
    {
        return id;
    }
    
    public int getAuthorId()
    {
        return authorId;
    }
    
    public int getItemId()
    {
        return itemId;
    }
    
    public String getText()
    {
        return text;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null || !(obj instanceof Comment))
        {
            return false;
        }
        if(obj == this)
        {
            return true;
        }
        Comment commentObj = (Comment)obj;
        return (commentObj.getAuthorId() == authorId
                && commentObj.getItemId() == itemId 
                && ((commentObj.getText() == null && text == null) || 
                    (commentObj.getText() != null && commentObj.getText().equals(text))));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.itemId;
        hash = 53 * hash + this.authorId;
        hash = 53 * hash + Objects.hashCode(this.text);
        return hash;
    }
}
