package com.jersson.arrivasplata.swtvap.api.web.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jersson.arrivasplata.swtvap.api.web.enums.Lang;
import com.jersson.arrivasplata.swtvap.api.web.enums.StatusCatalog;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "swtvap_catalogs")
public class WCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long catalogId;

    @Column(length = 50)
    private String code;

    @Column(length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 200)
    private String nameEn;

    @Column(columnDefinition = "TEXT")
    private String descriptionEn;

    @Enumerated(EnumType.ORDINAL)
    private StatusCatalog status;

    @Enumerated(EnumType.ORDINAL)
    private Lang lang;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "swtvap_categories_catalogs",
            joinColumns = @JoinColumn(name = "catalog_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonManagedReference
    private Set<WCategory> categories = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "swtvap_products_catalogs",
            joinColumns = @JoinColumn(name = "catalog_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonManagedReference
    private Set<WProduct> products = new HashSet<>();
}