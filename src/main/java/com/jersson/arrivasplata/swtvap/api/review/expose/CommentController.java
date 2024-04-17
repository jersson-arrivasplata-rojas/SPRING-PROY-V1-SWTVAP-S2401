package com.jersson.arrivasplata.swtvap.api.review.expose;

import com.jersson.arrivasplata.swtvap.api.review.model.CommentRequest;
import com.jersson.arrivasplata.swtvap.api.review.model.CommentResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentController {
    Flux<CommentResponse> getAllComments();

    Mono<CommentResponse> getCommentById(Long id);

    Mono<CommentResponse> createComment(CommentRequest comment);

    Mono<CommentResponse> updateComment(Long id, CommentRequest updatedComment);

    Mono<Void> deleteComment(Long id);
}
