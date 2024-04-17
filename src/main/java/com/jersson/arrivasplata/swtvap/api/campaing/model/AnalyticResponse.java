package com.jersson.arrivasplata.swtvap.api.campaing.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AnalyticResponse {

    private Long analyticId;
    private String visitedPage;
    private LocalDate visitedDate;
    private LocalDate deletedAt;
}