package com.jersson.arrivasplata.swtvap.api.web.model;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class WProductRequest {
    private Long productId;
    private String code;
    private String name;
    private String description;
    private String name_en;
    private String description_en;
    private BigDecimal price;
    private BigDecimal priceUSD;
    private BigDecimal priceEUR;
    private Long stock;
    private Long stockMin;
    private String otherDetails;
    private String otherDetails_en;
    private Status status;
    private LocalDate deletedAt;
}
