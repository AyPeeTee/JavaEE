package AyPeeTee.managers;

import AyPeeTee.entities.PostEntity;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class PostsManager {

    private ArrayList<PostEntity> postEntities = new ArrayList<>();

    public ArrayList<PostEntity> getAll() {
        return postEntities;
    }

    public PostEntity get(int id) {
        return postEntities.get(id);
    }

    public void create(PostEntity post) {
        post.setId(postEntities.size() + 1);
        postEntities.add(post);
    }

    public void update(PostEntity post, int id) {
        postEntities.remove(id - 1);
        postEntities.add(id - 1, post);
        post.setId(id);
    }

    public void delete(int id) {
        postEntities.remove(id);
    }
}
