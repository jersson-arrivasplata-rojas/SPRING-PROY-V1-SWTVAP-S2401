package com.jersson.arrivasplata.swtvap.api.order.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.OrderAmount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderAmountService {
    Flux<OrderAmount> getAllOrderAmount();

    Mono<OrderAmount> getOrderAmountById(Long id);

    Mono<OrderAmount> createOrderAmount(OrderAmount orderAmount);

    Mono<OrderAmount> updateOrderAmount( OrderAmount orderAmount);

    Mono<Void> deleteOrderAmount(Long id);

    Flux<OrderAmount> findByOrderCode(String orderCode);
}
