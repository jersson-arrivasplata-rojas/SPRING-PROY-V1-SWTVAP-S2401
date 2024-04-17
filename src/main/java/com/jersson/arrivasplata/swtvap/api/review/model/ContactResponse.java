package com.jersson.arrivasplata.swtvap.api.review.model;

import com.jersson.arrivasplata.swtvap.api.review.enums.StatusContact;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContactResponse {
    private Long contactId;
    private String name;
    private String contact;
    private String email;
    private String details;
    private StatusContact status;
    private LocalDate deletedAt;
}
