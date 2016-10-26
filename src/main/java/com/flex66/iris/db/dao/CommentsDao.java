package com.flex66.iris.db.dao;

import com.flex66.iris.db.domainobject.Comment;
import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import org.hibernate.SessionFactory;



public class CommentsDao extends AbstractDAO<Comment>{

    public CommentsDao(SessionFactory sessionFactory) 
    {
        super(sessionFactory);
    }
    

    public List<Comment> findByItem(int itemId)
    {
        return list(namedQuery("com.flex66.iris.db.findByItem")
            .setParameter("id", itemId));
    }
    
    
    public long upsert(Comment comment)
    {
        return persist(comment).getId();
    }
    
}
