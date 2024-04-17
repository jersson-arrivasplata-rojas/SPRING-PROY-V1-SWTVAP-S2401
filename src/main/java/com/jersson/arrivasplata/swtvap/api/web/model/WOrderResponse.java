package com.jersson.arrivasplata.swtvap.api.web.model;

import com.jersson.arrivasplata.swtvap.api.web.enums.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class WOrderResponse {
    private Long orderId;
    private Long clientId;
    private String code;
    private String orderDate;
    private OrderStatus status;
    private String address;
    private BigDecimal subtotal;
    private BigDecimal subtotalUSD;
    private BigDecimal subtotalEUR;
    private BigDecimal taxes;
    private BigDecimal taxesUSD;
    private BigDecimal taxesEUR;
    private BigDecimal discountAmount;
    private BigDecimal total;
    private BigDecimal totalUSD;
    private BigDecimal totalEUR;
    private Boolean pickUp;
    private String otherDetails;
    private LocalDate deletedAt;
}
