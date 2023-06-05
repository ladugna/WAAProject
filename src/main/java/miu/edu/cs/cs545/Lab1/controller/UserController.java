package miu.edu.cs.cs545.Lab1.controller;

import miu.edu.cs.cs545.Lab1.domain.Comment;
import miu.edu.cs.cs545.Lab1.domain.Post;
import miu.edu.cs.cs545.Lab1.domain.User;
import miu.edu.cs.cs545.Lab1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
   private UserService userService;


     @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public User UserById(@PathVariable("id") long id){
         return userService.findUserById(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public User saveUser(@RequestBody User user){
         return userService.createUser(user);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/posts")
    public List<Post> findPostsOfUser(@PathVariable("id") long id){
        return userService.findAllPostOfParticularUser(id);
    }

    /*public List<User> findAllUserOfPost(){
         return userService.findUserWhoHaveMoreThanOnePost();
    }*/
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter")
    public List<User> findAllUserOfPost(@RequestParam("num") int num){
        return userService.findByPostsSizeGreaterThan(num);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/posts/filter")
    public List<User> findUserAndPostThatMatchTitle(@RequestParam("title") String title){
        return userService.postThatMatchTitle(title).stream().toList();
    }
    @GetMapping("/{uid}/posts/{pid}/comments/{cid}")
    public ResponseEntity<?> findCommentByUserAndPostId(@PathVariable("uid") int uid,
                                                        @PathVariable("pid") int pid,
                                                        @PathVariable("cid") int cid){
      return new ResponseEntity<>(userService.findCommentsPost(uid,pid,cid), HttpStatus.OK);

    }
}
