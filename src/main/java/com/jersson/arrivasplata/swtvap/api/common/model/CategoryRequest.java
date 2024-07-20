package com.jersson.arrivasplata.swtvap.api.common.model;

import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CategoryRequest {
    private Long categoryId;
    private String name;
    private String description;
    private String nameEn;
    private String descriptionEn;
    private Status status;
    private LocalDate deletedAt;
}
//(Modelo de solicitud)