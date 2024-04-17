package com.jersson.arrivasplata.swtvap.api.web.model;

import lombok.Data;

import java.util.Map;

@Data
public class WCheckout {
    private WOrderRequest order;
    private WClient client;
    private Map<String, Integer> cart;
}
