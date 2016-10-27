package com.flex66.iris.resources;

import com.flex66.iris.core.domainobject.UserComment;
import com.flex66.iris.core.payload.CreateCommentRequestPayload;
import com.flex66.iris.core.payload.CreateCommentResponsePayload;
import com.flex66.iris.core.payload.GetCommentsResponsePayload;
import io.dropwizard.hibernate.UnitOfWork;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/comment")
public class CommentResource 
{
    private static final Logger logger = LoggerFactory.getLogger(CommentResource.class);
    
    private final CommentDelegate commentDelegate;
    
    public CommentResource(CommentDelegate delegate)
    {
        commentDelegate = delegate;
    }
    
    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/authors/{authorId}")
    public Response createComment(@PathParam("authorId") int authorId, CreateCommentRequestPayload commentRequest)
    {
        logger.info("createComment - author:{}", authorId);
        
        long commentId = commentDelegate.createComment(authorId, commentRequest);
        return Response.ok().entity(new CreateCommentResponsePayload(commentId)).build();
    }
    
    
    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/comments/{itemId}")
    public Response getComments(@PathParam("itemId") int itemId)
    {
        logger.info("getComments - item:{}", itemId);
        
        List<UserComment> listUserComments = commentDelegate.getComments(itemId);
        return Response.ok().entity(new GetCommentsResponsePayload(listUserComments)).build();
    }
}
