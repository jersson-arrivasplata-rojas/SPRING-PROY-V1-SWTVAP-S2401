package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WCommentService;
import com.jersson.arrivasplata.swtvap.api.web.expose.WCommentController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.WCommentMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.WComment;
import com.jersson.arrivasplata.swtvap.api.web.model.WCommentRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WCommentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/w-comments", produces = "application/vnd.swtvap-api-w-comments.v1+json")
public class WCommentControllerImpl implements WCommentController {
    private final WCommentService commentService;
    private final WCommentMapper commentMapper;

    public WCommentControllerImpl(WCommentService commentService, WCommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<WCommentResponse> createComment(@RequestBody WCommentRequest commentRequest) {
        WComment comment = commentMapper.commentRequestToComment(commentRequest);

        return Mono.just(commentService.createComment(comment))
                .map(newComment -> {
                    WCommentResponse commentResponse = commentMapper.commentToCommentResponse(newComment);
                    return commentResponse;
                });
    }

}
