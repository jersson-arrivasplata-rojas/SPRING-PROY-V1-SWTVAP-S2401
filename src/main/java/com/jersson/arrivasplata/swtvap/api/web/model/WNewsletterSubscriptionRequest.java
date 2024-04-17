package com.jersson.arrivasplata.swtvap.api.web.model;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WNewsletterSubscriptionRequest {

    private Long newsletterSubscriptionId;
    private String email;
    private LocalDate subscribedAt;
    private Status status;
    private LocalDate deletedAt;
}