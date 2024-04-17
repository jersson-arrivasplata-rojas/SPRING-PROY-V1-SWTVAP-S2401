package com.jersson.arrivasplata.swtvap.api.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import com.jersson.arrivasplata.swtvap.api.web.enums.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "swtvap_comments")
public class WComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long commentId;

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

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonBackReference
    private WProduct product;
}
