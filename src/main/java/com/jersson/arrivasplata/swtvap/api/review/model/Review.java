package com.jersson.arrivasplata.swtvap.api.review.model;

import com.jersson.arrivasplata.swtvap.api.common.model.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "swtvap_reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long reviewId;

    @Column(name = "product_id")
    private Long productId;

    @Column()
    private Long score;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Column(name = "review_at")
    private LocalDate reviewAt;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;
}
