package miu.edu.cs.cs545.Lab1.service.impl;

import miu.edu.cs.cs545.Lab1.domain.Post;
import miu.edu.cs.cs545.Lab1.repository.PostRepository;
import miu.edu.cs.cs545.Lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findPostById(long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Collection<Post> postThatMatchTitle(String title) {
        return postRepository.postThatMatchTitle(title);
    }

    /*@Override
    public Comment saveCommentBYPostId(long id, Comment comment) {
         Post post= findPostById(id);
         if(post!=null){
             return postRepository.saveCommentBYPostId(id, comment);
         }
         return null;

    }*/
}
