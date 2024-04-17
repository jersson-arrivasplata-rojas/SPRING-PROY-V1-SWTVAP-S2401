package com.jersson.arrivasplata.swtvap.api.web.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "swtvap_products_parameters")
public class WProductParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "product_id")
    private WProduct product;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "parameter_id")
    private WParameterProduct parameter;

}
