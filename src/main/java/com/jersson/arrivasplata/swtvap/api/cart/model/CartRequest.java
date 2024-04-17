package com.jersson.arrivasplata.swtvap.api.cart.model;

import com.jersson.arrivasplata.swtvap.api.cart.enums.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CartRequest {
    private Long cartId;
    private String code;
    private LocalDate cartDate;
    private Status status;
}
