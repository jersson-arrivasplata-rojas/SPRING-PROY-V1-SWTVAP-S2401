package com.jersson.arrivasplata.swtvap.api.review.business.service;

import com.jersson.arrivasplata.swtvap.api.review.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    Review getReviewById(Long id);

    Review createReview(Review review);

    Review updateReview(Long id, Review updatedReview);

    void deleteReviewById(Long id);
}
