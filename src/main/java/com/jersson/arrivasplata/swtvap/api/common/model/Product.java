package com.jersson.arrivasplata.swtvap.api.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jersson.arrivasplata.swtvap.api.product.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "swtvap_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productId;

    @Column(name = "code", length = 50)
    private String code;
    @Column(name = "path", columnDefinition = "TEXT")
    private String path;

    @Column(name = "name", length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 200)
    private String nameEn;

    @Column(columnDefinition = "TEXT")
    private String descriptionEn;

    @Column(name = "price", precision = 50, scale = 10)
    private BigDecimal price;

    @Column(name = "priceUSD", precision = 50, scale = 10)
    private BigDecimal priceUSD;

    @Column(name = "priceEUR", precision = 50, scale = 10)
    private BigDecimal priceEUR;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "stock_min")
    private Long stockMin;

    @Column(columnDefinition = "TEXT")
    private String otherDetails;

    @Column(columnDefinition = "TEXT")
    private String otherDetailsEn;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductCategory> productCategories;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductUnit> productUnits;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductProvider> productProviders;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ProductImage> productImages;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ProductDiscount> productDiscounts;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ProductParameter> productParameters;
}