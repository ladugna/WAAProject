package miu.edu.cs.cs545.Lab1.service.impl;

import jakarta.transaction.Transactional;
import miu.edu.cs.cs545.Lab1.domain.Comment;
import miu.edu.cs.cs545.Lab1.domain.Post;
import miu.edu.cs.cs545.Lab1.domain.User;
import miu.edu.cs.cs545.Lab1.repository.UserRepository;
import miu.edu.cs.cs545.Lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
//         System.out.println("print");
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<Post> findAllPostOfParticularUser(long id) {
        //return userRepository.findById(id).get().getPosts();
        return userRepository.findById(id).orElseThrow().getPosts();
    }

   public List<User> findByPostsSizeGreaterThan(int number){
       return userRepository.findByPostsSizeGreaterThan(number);
   }

    @Override
    public Collection<User> postThatMatchTitle(String title) {
        return userRepository.postThatMatchTitle(title);
    }

    @Override
    public Comment findCommentsPost(int uid, int pid, int cid) {
        return userRepository.findCommentsPost(uid, pid, cid) ;
    }
}
