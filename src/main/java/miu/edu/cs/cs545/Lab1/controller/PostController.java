package miu.edu.cs.cs545.Lab1.controller;

import miu.edu.cs.cs545.Lab1.aop.LogMe;
import miu.edu.cs.cs545.Lab1.domain.Post;
import miu.edu.cs.cs545.Lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;
  @LogMe
    @GetMapping
   public ResponseEntity<?> getAllPosts(){
        return new ResponseEntity<> (postService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable("id") long id){
        return new ResponseEntity<>(postService.findPostById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> savePost(@RequestBody Post post){
        return new ResponseEntity<>(postService.createPost(post),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        postService.deletePost(id);
        }

     /*   @PostMapping("/{id}/comments")
    public Comment addComment(@PathVariable("id") long id, @RequestBody Comment comment){
        return postService.saveCommentBYPostId(id, comment);
        }*/
    @GetMapping("/filter")
     Collection<Post> postThatMatchTitle(@RequestParam("title") String title){
       return postService.postThatMatchTitle(title);

     }

}
