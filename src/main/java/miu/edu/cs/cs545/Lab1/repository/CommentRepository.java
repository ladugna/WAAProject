package miu.edu.cs.cs545.Lab1.repository;

import miu.edu.cs.cs545.Lab1.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


   /* @Query("select c from User u join u.posts p join p.comments c where " +
            "  u.id=:uid and p.id=:pid and c.id=:cid")
     Comment findCommentsPost(@Param("uid") int uid, @Param("pid") int pid, @Param("cid") int cid);*/
}
