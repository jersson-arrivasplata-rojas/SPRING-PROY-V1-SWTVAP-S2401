package com.jersson.arrivasplata.swtvap.api.common.model;

import com.jersson.arrivasplata.swtvap.api.product.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProductResponse {
    private Long productId;
    private String code;
    private String name;
    private String path;
    private String description;
    private String nameEn;
    private String descriptionEn;
    private BigDecimal price;
    private BigDecimal priceUSD;
    private BigDecimal priceEUR;
    private Long stock;
    private Long stockMin;
    private String otherDetails;
    private String otherDetailsEn;
    private Status status;
    private LocalDate deletedAt;
}
