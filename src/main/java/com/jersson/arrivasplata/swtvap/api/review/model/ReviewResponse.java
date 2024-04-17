package com.jersson.arrivasplata.swtvap.api.review.model;

import com.jersson.arrivasplata.swtvap.api.common.model.Product;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewResponse {
    private Long reviewId;
    private Long productId;
    private Long score;
    private String comment;
    private LocalDate reviewAt;
    private LocalDate deletedAt;
    private Product product;
}
