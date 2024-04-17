package com.jersson.arrivasplata.swtvap.api.common.model;

import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class UnitResponse {
    private Long unitId;
    private String unitName;
    private String abbreviation;
    private BigDecimal conversionFactor;
    private Status status;
    private LocalDate deletedAt;
}
