package com.jersson.arrivasplata.swtvap.api.common.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "swtvap_orders_amounts")
public class OrderAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long orderAmountId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(length = 50)
    private String name;

    @Column(name = "amount", precision = 50, scale = 10)
    private BigDecimal amount;

    @Column(name = "amountUSD", precision = 50, scale = 10)
    private BigDecimal amountUSD;

    @Column(name = "amountEUR", precision = 50, scale = 10)
    private BigDecimal amountEUR;

    @Column(columnDefinition = "TEXT")
    private String otherDetails;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

}
