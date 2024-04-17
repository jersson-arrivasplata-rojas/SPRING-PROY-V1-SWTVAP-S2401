package com.jersson.arrivasplata.swtvap.api.order.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.OrderDetailRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderDetailResponse;
import reactor.core.publisher.Mono;

public interface OrderDetailController {
    Mono<OrderDetailResponse> getOrderDetailById(Long id);

    Mono<OrderDetailResponse> createOrderDetail(OrderDetailRequest orderDetailRequest);

    Mono<OrderDetailResponse> updateOrderDetail(Long id, OrderDetailRequest updatedOrderDetailRequest);

    Mono<Void> deleteOrderDetail(Long id);
}
