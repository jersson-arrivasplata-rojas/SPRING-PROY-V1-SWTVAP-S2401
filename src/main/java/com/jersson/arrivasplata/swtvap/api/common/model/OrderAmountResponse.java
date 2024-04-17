package com.jersson.arrivasplata.swtvap.api.common.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrderAmountResponse {
    private Long orderAmountId;
    private Long orderId;
    private String name;
    private BigDecimal amount;
    private BigDecimal amountUSD;
    private BigDecimal amountEUR;
    private String otherDetails;
    private LocalDate deletedAt;
}
