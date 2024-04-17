package com.jersson.arrivasplata.swtvap.api.web.model;


import com.jersson.arrivasplata.swtvap.api.web.enums.Lang;
import com.jersson.arrivasplata.swtvap.api.web.enums.StatusCatalog;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class WCatalogRequest {
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
