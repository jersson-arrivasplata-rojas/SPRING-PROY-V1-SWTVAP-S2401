package com.jersson.arrivasplata.swtvap.api.order.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.OrderRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderController {
    Flux<Object> getOrderSummary();
    Flux<OrderResponse> getAllOrders();
    Mono<OrderResponse> getOrderById(Long id);
    Mono<OrderResponse> createOrder(OrderRequest orderRequest);
    Mono<OrderResponse> updateOrder(Long id, OrderRequest orderRequest);
    Mono<Void> deleteOrder(Long id);

}
