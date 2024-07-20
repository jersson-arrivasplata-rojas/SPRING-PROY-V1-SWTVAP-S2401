package com.jersson.arrivasplata.swtvap.api.common.model;

import com.jersson.arrivasplata.swtvap.api.inventory.enums.Lang;
import com.jersson.arrivasplata.swtvap.api.inventory.enums.StatusCatalog;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CatalogRequest {
    private Long catalogId;
    private String code;
    private String name;
    private String description;
    private String nameEn;
    private String descriptionEn;
    private StatusCatalog status;
    private Lang lang;
    private LocalDate deletedAt;
}
