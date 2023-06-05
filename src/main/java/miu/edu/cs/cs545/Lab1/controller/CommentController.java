package miu.edu.cs.cs545.Lab1.controller;

import lombok.Data;
import miu.edu.cs.cs545.Lab1.domain.Comment;
import miu.edu.cs.cs545.Lab1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping
    public ResponseEntity<?> findAllComments(){
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCommentById(@PathVariable("id") long id){
        return new ResponseEntity<>(commentService.findCommentById(id),HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Comment saveComment(@RequestBody Comment comment){
        return commentService.createComment(comment);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") long id){
        commentService.deleteComment(id);
    }
 /*  @GetMapping("/users/{uid}/posts/{pid}/comments/{cid}")
    public ResponseEntity<?> findCommentByPostAndUser(@PathVariable("uid") int uid,
                                                      @PathVariable("pid") int pid,
                                                       @PathVariable("cid") int cid){
        return new ResponseEntity<>(commentService.findCommentsPost(uid, pid, cid),HttpStatus.OK);
   }*/
}
