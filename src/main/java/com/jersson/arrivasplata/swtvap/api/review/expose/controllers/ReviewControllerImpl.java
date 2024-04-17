package com.jersson.arrivasplata.swtvap.api.review.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.review.business.service.ReviewService;
import com.jersson.arrivasplata.swtvap.api.review.expose.ReviewController;
import com.jersson.arrivasplata.swtvap.api.review.mapper.ReviewMapper;
import com.jersson.arrivasplata.swtvap.api.review.model.Review;
import com.jersson.arrivasplata.swtvap.api.review.model.ReviewRequest;
import com.jersson.arrivasplata.swtvap.api.review.model.ReviewResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/reviews", produces = "application/vnd.swtvap-api-reviews.v1+json")
public class ReviewControllerImpl implements ReviewController {
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    public ReviewControllerImpl(ReviewService reviewService, ReviewMapper reviewMapper) {
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ReviewResponse> getAllReviews() {
        return Flux.fromIterable(reviewService.getAllReviews())
                .map(review -> {
                    ReviewResponse reviewResponse = reviewMapper.reviewToReviewResponse(review);
                    return reviewResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ReviewResponse> getReviewById(@PathVariable Long id) {
        return Mono.just(reviewService.getReviewById(id))
                .map(review -> {
                    ReviewResponse reviewResponse = reviewMapper.reviewToReviewResponse(review);
                    return reviewResponse;
                })
                .defaultIfEmpty(new ReviewResponse());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ReviewResponse> createReview(@RequestBody ReviewRequest reviewRequest) {
        Review review = reviewMapper.reviewRequestToReview(reviewRequest);

        return Mono.just(reviewService.createReview(review))
                .map(newReview -> {
                    ReviewResponse reviewResponse = reviewMapper.reviewToReviewResponse(newReview);
                    return reviewResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ReviewResponse> updateReview(@PathVariable Long id, @RequestBody ReviewRequest reviewRequest) {
        Review review = reviewMapper.reviewRequestToReview(reviewRequest);

        return Mono.just(reviewService.updateReview(id, review))
                .map(updatedReview -> {
                    ReviewResponse reviewResponse = reviewMapper.reviewToReviewResponse(updatedReview);
                    return reviewResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
        return Mono.empty();
    }
}
