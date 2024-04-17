package com.jersson.arrivasplata.swtvap.api.order.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {
    Flux<Object> getOrderSummary();
    Flux<Order> getAllOrders();
    Mono<Order> getOrderById(Long id);
    Mono<Order> createOrder(Order order);
    Mono<Order> updateOrder( Order order);
    Mono<Void> deleteOrderById(Long id);
}
