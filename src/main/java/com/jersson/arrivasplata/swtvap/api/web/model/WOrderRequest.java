package com.jersson.arrivasplata.swtvap.api.web.model;

import com.jersson.arrivasplata.swtvap.api.web.enums.OrderStatus;
import lombok.Data;

@Data
public class WOrderRequest {
    private String code;
    private String orderDate;
    private OrderStatus status;
    private Boolean pickUp;
}
