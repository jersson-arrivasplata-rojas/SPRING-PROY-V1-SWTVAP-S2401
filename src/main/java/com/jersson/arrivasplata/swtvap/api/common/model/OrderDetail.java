package com.jersson.arrivasplata.swtvap.api.common.model;

import com.jersson.arrivasplata.swtvap.api.order.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "swtvap_orders_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long orderDetailId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "unit_price", precision = 50, scale = 10)
    private BigDecimal unitPrice;

    @Column(name = "unit_priceUSD", precision = 50, scale = 10)
    private BigDecimal unitPriceUSD;

    @Column(name = "unit_priceEUR", precision = 50, scale = 10)
    private BigDecimal unitPriceEUR;

    @Column(name = "subtotal", precision = 50, scale = 10)
    private BigDecimal subtotal;

    @Column(name = "subtotalUSD", precision = 50, scale = 10)
    private BigDecimal subtotalUSD;

    @Column(name = "subtotalEUR", precision = 50, scale = 10)
    private BigDecimal subtotalEUR;

    @Column(name = "discount_percentage")
    private Long discountPercentage;

    @Column(columnDefinition = "TEXT")
    private String otherDetails;

    @Column(name = "otherDetails_en", columnDefinition = "TEXT")
    private String otherDetailsEn;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;
/*
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Product> product;
*/
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product Product;

}
