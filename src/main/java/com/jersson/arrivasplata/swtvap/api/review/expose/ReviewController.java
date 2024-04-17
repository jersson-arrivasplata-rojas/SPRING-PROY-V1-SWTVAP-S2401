package com.jersson.arrivasplata.swtvap.api.review.expose;

import com.jersson.arrivasplata.swtvap.api.review.model.ReviewRequest;
import com.jersson.arrivasplata.swtvap.api.review.model.ReviewResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewController {
    Flux<ReviewResponse> getAllReviews();

    Mono<ReviewResponse> getReviewById(Long id);

    Mono<ReviewResponse> createReview(ReviewRequest review);

    Mono<ReviewResponse> updateReview(Long id, ReviewRequest updatedReview);

    Mono<Void> deleteReview(Long id);
}
