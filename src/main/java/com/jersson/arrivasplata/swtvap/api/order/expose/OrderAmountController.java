package com.jersson.arrivasplata.swtvap.api.order.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.OrderAmountRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderAmountResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderAmountController {
    Flux<OrderAmountResponse> getAllOrderAmount();
    Mono<OrderAmountResponse> getOrderAmountById(Long id);

    Mono<OrderAmountResponse> createOrderAmount(OrderAmountRequest orderAmountRequest);

    Mono<OrderAmountResponse> updateOrderAmount(Long id, OrderAmountRequest orderAmountRequest);

    Mono<Void> deleteOrderAmount(Long id);
}
