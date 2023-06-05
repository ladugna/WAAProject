package miu.edu.cs.cs545.Lab1.repository;

import miu.edu.cs.cs545.Lab1.domain.Comment;
import miu.edu.cs.cs545.Lab1.domain.Post;
import miu.edu.cs.cs545.Lab1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   /* @Query("select c from User c join c.posts p where p.size>1 ")
    public List<User> findUserWhoHaveMoreThanOnePost();*/
   // public List<User> findUsersByPostsGreaterThan(int number);


    @Query("select c from User c join fetch c.posts d where size(d) >:num")
    //@Query("SELECT u FROM User u JOIN FETCH u.posts p WHERE p.size() > :num") //this is showing error but works
    List<User> findByPostsSizeGreaterThan(@Param("num") int num);

    @Query("select u from User u join u.posts p where p.title=:title")
    Collection<User> postThatMatchTitle(@Param("title") String title);

    @Query("select c from User u Join u.posts p Join p.comments c where u.id = :uid and p.id = :pid and c.id = :cid ")
    Comment findCommentsPost(@Param("uid") int uid,
                             @Param("pid") int pid,
                             @Param("cid") int cid);
}
