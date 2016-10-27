package com.flex66.iris;

import com.flex66.iris.db.dao.CommentsDao;
import com.flex66.iris.db.domainobject.Comment;
import com.flex66.iris.exception.IllegalArgumentExceptionMapper;
import com.flex66.iris.exception.RuntimeExceptionMapper;
import com.flex66.iris.resources.CommentDelegate;
import com.flex66.iris.resources.CommentResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class IrisApplication extends Application<IrisConfiguration> {

    private final HibernateBundle<IrisConfiguration> hibernateBundle 
        = new HibernateBundle<IrisConfiguration>(Comment.class) 
        {
            @Override
            public DataSourceFactory getDataSourceFactory(IrisConfiguration configuration) 
            {
                return configuration.getDataSourceFactory();
            }
        };
    
    
    
    
    
    public static void main(final String[] args) throws Exception {
        new IrisApplication().run(args);
    }

    @Override
    public String getName() {
        return "iris";
    }

    @Override
    public void initialize(final Bootstrap<IrisConfiguration> bootstrap) 
    {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final IrisConfiguration configuration, final Environment environment) 
    {
        environment.jersey().register(new CommentResource(
                new CommentDelegate(
                    new CommentsDao(hibernateBundle.getSessionFactory()))));
        
        environment.jersey().register(new IllegalArgumentExceptionMapper());
        environment.jersey().register(new RuntimeExceptionMapper());
    }

}
