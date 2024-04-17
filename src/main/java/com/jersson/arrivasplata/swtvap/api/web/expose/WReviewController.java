package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.WReviewRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WReviewResponse;
import reactor.core.publisher.Mono;

public interface WReviewController {
    Mono<WReviewResponse> createReview(WReviewRequest review);

}
