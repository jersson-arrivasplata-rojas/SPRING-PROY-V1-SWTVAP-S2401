package com.jersson.arrivasplata.swtvap.api.web.model;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class WOrderDetailResponse {
    private Long orderDetailId;
    private Long orderId;
    private Long productId;
    private Long quantity;
    private BigDecimal unitPrice;
    private BigDecimal unitPriceUSD;
    private BigDecimal unitPriceEUR;
    private BigDecimal subtotal;
    private BigDecimal subtotalUSD;
    private BigDecimal subtotalEUR;
    private Long discountPercentage;
    private String otherDetails;
    private String otherDetailsEn;
    private Status status;
    private LocalDate deletedAt;
    private WOrder order;
    private WProduct Product;
}
