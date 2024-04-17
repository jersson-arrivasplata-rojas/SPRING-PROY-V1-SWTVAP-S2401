package com.jersson.arrivasplata.swtvap.api.common.model;
import com.jersson.arrivasplata.swtvap.api.relationship.enums.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProviderRequest {
    private Long providerId;
    private String name;
    private String address;
    private String phone;
    private String cellphone;
    private String countryCode;
    private String email;
    private Boolean whatsapp;
    private String details;
    private String otherDetails;
    private Status status;
    private LocalDate deletedAt;
}
