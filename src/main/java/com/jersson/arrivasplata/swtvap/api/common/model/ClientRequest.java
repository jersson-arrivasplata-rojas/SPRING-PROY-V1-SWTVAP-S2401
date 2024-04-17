package com.jersson.arrivasplata.swtvap.api.common.model;
import com.jersson.arrivasplata.swtvap.api.relationship.enums.SourceAggregate;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientRequest {
    private Long clientId;
    private String name;
    private String address;
    private String phone;
    private String cellphone;
    private String countryCode;
    private String email;
    private Boolean whatsapp;
    private String details;
    private String otherDetails;
    private SourceAggregate sourceAggregate;
    private LocalDate deletedAt;
}
