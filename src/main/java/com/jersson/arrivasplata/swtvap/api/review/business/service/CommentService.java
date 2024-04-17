package com.jersson.arrivasplata.swtvap.api.review.business.service;

import com.jersson.arrivasplata.swtvap.api.review.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();

    Comment getCommentById(Long id);

    Comment createComment(Comment comment);

    Comment updateComment(Long id, Comment updatedComment);

    void deleteCommentById(Long id);
}
