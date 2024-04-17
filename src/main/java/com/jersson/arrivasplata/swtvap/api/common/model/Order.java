package com.jersson.arrivasplata.swtvap.api.common.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jersson.arrivasplata.swtvap.api.order.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "swtvap_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long orderId;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "order_date", length = 50)
    private String orderDate;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    @Column(name = "address", length = 250)
    private String address;

    @Column(name = "subtotal", precision = 50, scale = 10)
    private BigDecimal subtotal;

    @Column(name = "subtotalUSD", precision = 50, scale = 10)
    private BigDecimal subtotalUSD;

    @Column(name = "subtotalEUR", precision = 50, scale = 10)
    private BigDecimal subtotalEUR;

    @Column(name = "taxes", precision = 50, scale = 10)
    private BigDecimal taxes;

    @Column(name = "taxesUSD", precision = 50, scale = 10)
    private BigDecimal taxesUSD;

    @Column(name = "taxesEUR", precision = 50, scale = 10)
    private BigDecimal taxesEUR;

    @Column(name = "discount_amount", precision = 50, scale = 10)
    private BigDecimal discountAmount;

    @Column(name = "total", precision = 50, scale = 10)
    private BigDecimal total;

    @Column(name = "totalUSD", precision = 50, scale = 10)
    private BigDecimal totalUSD;

    @Column(name = "totalEUR", precision = 50, scale = 10)
    private BigDecimal totalEUR;

    @Column(name = "pick_up")
    private Boolean pickUp;

    @Column(columnDefinition = "TEXT")
    private String otherDetails;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<OrderAmount> orderAmount;
}
