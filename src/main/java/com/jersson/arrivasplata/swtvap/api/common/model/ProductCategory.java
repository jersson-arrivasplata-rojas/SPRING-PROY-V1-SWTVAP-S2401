package com.jersson.arrivasplata.swtvap.api.common.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@Entity
@Table(name = "swtvap_products_categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "category_id")
    private Category category;
}
