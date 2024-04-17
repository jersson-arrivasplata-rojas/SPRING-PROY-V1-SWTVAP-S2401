package com.jersson.arrivasplata.swtvap.api.review.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.review.business.service.CommentService;
import com.jersson.arrivasplata.swtvap.api.review.expose.CommentController;
import com.jersson.arrivasplata.swtvap.api.review.mapper.CommentMapper;
import com.jersson.arrivasplata.swtvap.api.review.model.Comment;
import com.jersson.arrivasplata.swtvap.api.review.model.CommentRequest;
import com.jersson.arrivasplata.swtvap.api.review.model.CommentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/comments", produces = "application/vnd.swtvap-api-comments.v1+json")
public class CommentControllerImpl implements CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public CommentControllerImpl(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<CommentResponse> getAllComments() {
        return Flux.fromIterable(commentService.getAllComments())
                .map(comment -> {
                    CommentResponse commentResponse = commentMapper.commentToCommentResponse(comment);
                    return commentResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CommentResponse> getCommentById(@PathVariable Long id) {
        return Mono.just(commentService.getCommentById(id))
                .map(comment -> {
                    CommentResponse commentResponse = commentMapper.commentToCommentResponse(comment);
                    return commentResponse;
                })
                .defaultIfEmpty(new CommentResponse());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CommentResponse> createComment(@RequestBody CommentRequest commentRequest) {
        Comment comment = commentMapper.commentRequestToComment(commentRequest);

        return Mono.just(commentService.createComment(comment))
                .map(newComment -> {
                    CommentResponse commentResponse = commentMapper.commentToCommentResponse(newComment);
                    return commentResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CommentResponse> updateComment(@PathVariable Long id, @RequestBody CommentRequest commentRequest) {
        Comment comment = commentMapper.commentRequestToComment(commentRequest);

        return Mono.just(commentService.updateComment(id, comment))
                .map(updatedComment -> {
                    CommentResponse commentResponse = commentMapper.commentToCommentResponse(updatedComment);
                    return commentResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteCommentById(id);
        return Mono.empty();
    }
}
