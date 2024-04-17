package com.jersson.arrivasplata.swtvap.api.web.business.service;

import com.jersson.arrivasplata.swtvap.api.web.model.WCheckout;
import com.jersson.arrivasplata.swtvap.api.web.model.WOrder;
import reactor.core.publisher.Mono;

public interface WOrderService {
    Mono<WOrder> createOrder(WCheckout checkout);
}
