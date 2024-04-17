package com.jersson.arrivasplata.swtvap.api.common.model;

import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CategoryResponse {
    private Long categoryId;
    private String name;
    private String description;
    private String name_en;
    private String description_en;
    private Status status;
    private LocalDate deletedAt;
}
//(Modelo de respuesta)
