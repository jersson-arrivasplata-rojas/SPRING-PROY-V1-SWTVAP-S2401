package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WReviewService;
import com.jersson.arrivasplata.swtvap.api.web.expose.WReviewController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.WReviewMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.WReview;
import com.jersson.arrivasplata.swtvap.api.web.model.WReviewRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WReviewResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/w-reviews", produces = "application/vnd.swtvap-api-w-reviews.v1+json")
public class WReviewControllerImpl implements WReviewController {
    private final WReviewService reviewService;
    private final WReviewMapper reviewMapper;

    public WReviewControllerImpl(WReviewService reviewService, WReviewMapper reviewMapper) {
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<WReviewResponse> createReview(@RequestBody WReviewRequest reviewRequest) {
        WReview review = reviewMapper.reviewRequestToReview(reviewRequest);

        return Mono.just(reviewService.createReview(review))
                .map(newReview -> {
                    WReviewResponse reviewResponse = reviewMapper.reviewToReviewResponse(newReview);
                    return reviewResponse;
                });
    }

}
