package com.jersson.arrivasplata.swtvap.api.web.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@Entity
@Table(name = "swtvap_products_units")
public class WProductUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "product_id")
    private WProduct product;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "unit_id")
    private WUnit unit;
}
