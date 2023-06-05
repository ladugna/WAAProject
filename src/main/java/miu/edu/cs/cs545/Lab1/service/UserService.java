package miu.edu.cs.cs545.Lab1.service;

import miu.edu.cs.cs545.Lab1.domain.Comment;
import miu.edu.cs.cs545.Lab1.domain.Post;
import miu.edu.cs.cs545.Lab1.domain.User;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UserService {
   public List<User> findAll();
   public User findUserById(long id);
  public User createUser(User user);
   public List<Post> findAllPostOfParticularUser(long id);
    public List<User> findByPostsSizeGreaterThan(int number);
    Collection<User> postThatMatchTitle(@Param("title") String title);
    Comment findCommentsPost(@Param("uid") int uid, @Param("pid") int pid, @Param("cid") int cid);
}
