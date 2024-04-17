package com.jersson.arrivasplata.swtvap.api.web.model;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class WCategoryResponse {
    private Long categoryId;
    private String name;
    private String description;
    private String nameEn;
    private String descriptionEn;
    private Status status;
    private LocalDate deletedAt;
    private ArrayList<WProduct> products;
}
//(Modelo de respuesta)
