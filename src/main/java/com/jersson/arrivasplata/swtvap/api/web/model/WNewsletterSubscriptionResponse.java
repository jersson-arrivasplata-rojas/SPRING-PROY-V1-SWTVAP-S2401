package com.jersson.arrivasplata.swtvap.api.web.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WNewsletterSubscriptionResponse {

    private String email;
    private LocalDate subscribedAt;
}