package com.jersson.arrivasplata.swtvap.api.common.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@Entity
@Table(name = "swtvap_categories_catalogs")
public class CategoryCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;
}
