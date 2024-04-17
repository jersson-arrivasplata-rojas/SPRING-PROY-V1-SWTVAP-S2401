package com.jersson.arrivasplata.swtvap.api.campaing.model;

import com.jersson.arrivasplata.swtvap.api.campaing.enums.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsletterSubscriptionResponse {

    private Long newsletterSubscriptionId;
    private String email;
    private LocalDate subscribedAt;
    private Status status;
    private LocalDate deletedAt;
}