package com.jersson.arrivasplata.swtvap.api.logistic.model;

import com.jersson.arrivasplata.swtvap.api.common.model.Order;
import com.jersson.arrivasplata.swtvap.api.common.model.Provider;
import com.jersson.arrivasplata.swtvap.api.logistic.enums.Status;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "swtvap_dispatches")
public class Dispatches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable()
    @Column(name = "order_id", nullable = true)
    private Long orderId;

    @Nullable()
    @Column(name = "provider_id", nullable = true)
    private Long providerId;

    @Column(precision = 10, scale = 2)
    private BigDecimal cost;

    @Column(name = "type_currency", length = 10)
    private String typeCurrency;

    private Timestamp date;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(columnDefinition = "TEXT")
    private String otherDetails;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @OneToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Provider provider;
/*
    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Order> order;
*/
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

}
