package com.jersson.arrivasplata.swtvap.api.web.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class WCatalogResponse {
    private Long catalogId;
    private String code;
    private String name;
    private String description;
    private String nameEn;
    private String descriptionEn;
    private ArrayList<WCategory> categories;
    private ArrayList<WProduct> products;
}
