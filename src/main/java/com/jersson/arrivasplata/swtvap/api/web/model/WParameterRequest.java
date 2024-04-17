package com.jersson.arrivasplata.swtvap.api.web.model;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class WParameterRequest {
    private Long id;
    private Long parentId;
    private Long groupId;
    private String description;
    private String value;
    private String value1;
    private String value2;
    private String code;
    private Long position;
    private Status status;
    private LocalDate deletedAt;
    private List<WParameter> children;
}
