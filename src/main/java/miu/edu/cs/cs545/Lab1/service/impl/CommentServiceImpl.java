package miu.edu.cs.cs545.Lab1.service.impl;

import miu.edu.cs.cs545.Lab1.domain.Comment;
import miu.edu.cs.cs545.Lab1.repository.CommentRepository;
import miu.edu.cs.cs545.Lab1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
   private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findCommentById(long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(long id) {
      commentRepository.deleteById(id);
    }

    /*@Override
    public List<Comment> findCommentsByPost(long id) {
        return commentRepository.findCommentsByPost(id);
    }*/
   /* public Comment findCommentsPost(@Param("uid") int uid, @Param("pid") int pid, @Param("cid") int cid){
       return commentRepository.findCommentsPost(uid, pid, cid);
    }*/

}
