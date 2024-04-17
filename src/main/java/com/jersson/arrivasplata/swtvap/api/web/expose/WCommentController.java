package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.WCommentRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WCommentResponse;
import reactor.core.publisher.Mono;

public interface WCommentController {
    Mono<WCommentResponse> createComment(WCommentRequest comment);

}
