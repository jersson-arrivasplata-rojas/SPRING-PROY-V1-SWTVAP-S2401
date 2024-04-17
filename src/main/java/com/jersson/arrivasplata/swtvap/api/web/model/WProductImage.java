package com.jersson.arrivasplata.swtvap.api.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "swtvap_products_images")
public class WProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productImageId;

    @Column(columnDefinition = "TEXT")
    private String path;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonBackReference
    private WProduct product;
}
