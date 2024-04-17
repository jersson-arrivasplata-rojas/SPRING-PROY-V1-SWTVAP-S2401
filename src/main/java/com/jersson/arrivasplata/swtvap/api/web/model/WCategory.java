package com.jersson.arrivasplata.swtvap.api.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "swtvap_categories")
public class WCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long categoryId;

    @Column(length = 50)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column(length = 50)
    private String nameEn;

    @Column(columnDefinition = "text")
    private String descriptionEn;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private Set<WCatalog> categories = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "swtvap_products_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonManagedReference
    private Set<WProduct> products = new HashSet<>();
}
//(Modelo de entidad)