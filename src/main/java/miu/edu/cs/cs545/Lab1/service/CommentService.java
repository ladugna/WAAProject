package miu.edu.cs.cs545.Lab1.service;

import miu.edu.cs.cs545.Lab1.domain.Comment;
import miu.edu.cs.cs545.Lab1.domain.Post;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentService {
    public List<Comment> findAll();
    public Comment findCommentById(long id);
    public Comment createComment(Comment comment);
    public void deleteComment(long id);
    //List<Comment> findCommentsByPost(long id);
    //Comment findCommentsPost( @Param("uid") int uid, @Param("pid") int pid, @Param("cid") int cid);

}
