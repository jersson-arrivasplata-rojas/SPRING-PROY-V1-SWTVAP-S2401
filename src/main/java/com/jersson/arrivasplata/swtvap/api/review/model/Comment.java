package com.jersson.arrivasplata.swtvap.api.review.model;

import com.jersson.arrivasplata.swtvap.api.common.model.Product;
import com.jersson.arrivasplata.swtvap.api.review.enums.Status;
import com.jersson.arrivasplata.swtvap.api.review.enums.Type;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "swtvap_comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long commentId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "reply_comment_id")
    private Long replyCommentId;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @Column(name = "name", length = 200)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "comment_at")
    private LocalDate commentAt;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;
}
