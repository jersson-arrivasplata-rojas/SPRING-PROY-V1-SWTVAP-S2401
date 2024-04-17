package com.jersson.arrivasplata.swtvap.api.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "swtvap_units")
public class WUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long unitId;

    @Column(name = "unit_name", length = 50)
    private String unitName;

    @Column(length = 10)
    private String abbreviation;

    @Column(name = "convertion_factor", precision = 10, scale = 4)
    private BigDecimal conversionFactor;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @ManyToMany(mappedBy = "units")
    @JsonBackReference
    private Set<WProduct> products = new HashSet<>();
}
