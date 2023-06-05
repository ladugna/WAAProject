package miu.edu.cs.cs545.Lab1.service;

import miu.edu.cs.cs545.Lab1.domain.Post;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface PostService {
    public List<Post> findAll();
    public Post findPostById(long id);
    public Post createPost(Post post);
    public void deletePost(long id);
   // Comment saveCommentBYPostId(long id, Comment comment);
   Collection<Post> postThatMatchTitle(@Param("title") String title);

}
