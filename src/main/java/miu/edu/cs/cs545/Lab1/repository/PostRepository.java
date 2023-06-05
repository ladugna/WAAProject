package miu.edu.cs.cs545.Lab1.repository;

import miu.edu.cs.cs545.Lab1.domain.Comment;
import miu.edu.cs.cs545.Lab1.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PostRepository extends JpaRepository<Post, Long> {
    //Comment saveCommentBYPostId(long id, Comment comment);

    @Query("select p from Post p where p.title=:title ")
    Collection<Post> postThatMatchTitle(@Param("title") String title);
}
