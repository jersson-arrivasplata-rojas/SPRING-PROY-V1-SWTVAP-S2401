package com.jersson.arrivasplata.swtvap.api.review.business.implementation;

import com.jersson.arrivasplata.swtvap.api.review.business.service.CommentService;
import com.jersson.arrivasplata.swtvap.api.review.enums.Status;
import com.jersson.arrivasplata.swtvap.api.review.model.Comment;
import com.jersson.arrivasplata.swtvap.api.review.repository.CommentRepository;
import com.jersson.arrivasplata.swtvap.api.review.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment updatedComment) {
        updatedComment.setCommentId(id);
        return commentRepository.save(updatedComment);
    }

    public void deleteCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment == null) {
            return;
        }
        comment.setStatus(Status.INACTIVE);
        comment.setDeletedAt(Common.builder().build().getCurrentDate());
        commentRepository.save(comment);
    }
}