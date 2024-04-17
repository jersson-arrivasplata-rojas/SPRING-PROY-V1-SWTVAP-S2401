package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.WCheckout;
import com.jersson.arrivasplata.swtvap.api.web.model.WOrderResponse;
import reactor.core.publisher.Mono;

public interface WOrderController {
    Mono<WOrderResponse> createOrder(WCheckout orderRequest);

}
