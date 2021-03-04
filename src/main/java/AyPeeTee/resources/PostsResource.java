package AyPeeTee.resources;

import AyPeeTee.managers.PostsManager;
import AyPeeTee.entities.PostEntity;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
public class PostsResource {

    @Inject
    private PostsManager postsManager;

    @GET
    public Response getAll() {
        return Response.ok(postsManager.get()).build();
    }

    @POST
    public Response create(PostEntity post) {
        postsManager.create(post);
        return Response.ok(post).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") int id, PostEntity post) {
        postsManager.update(post, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        postsManager.delete(id - 1);
        return Response.ok().build();
    }
}
