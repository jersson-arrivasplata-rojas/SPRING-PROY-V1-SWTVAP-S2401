package com.jersson.arrivasplata.swtvap.api.web.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WAnalyticRequest {

    private Long analyticId;
    private String visitedPage;
    private LocalDate visitedDate;
    private LocalDate deletedAt;
}