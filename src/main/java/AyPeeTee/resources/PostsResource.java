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
    @Path("getAll")
    public Response getAll() {
        return Response.ok(postsManager.getAll()).build();
    }

    @GET
    public Response get(@QueryParam("id") int id) {
        return Response.ok(postsManager.get(id)).build();
    }

    @POST
    public Response create(PostEntity post) {
        postsManager.create(post);
        return Response.ok(post).build();
    }

    @PUT
    public Response update(@QueryParam("id") int id, PostEntity post) {
        postsManager.update(post, id);
        return Response.ok().build();
    }

    @DELETE
    public Response delete(@QueryParam("id") int id) {
        postsManager.delete(id);
        return Response.ok("Done.").build();
    }
}
