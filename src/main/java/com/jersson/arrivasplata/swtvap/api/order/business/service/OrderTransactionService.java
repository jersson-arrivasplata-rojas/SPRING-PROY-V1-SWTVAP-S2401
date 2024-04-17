package com.jersson.arrivasplata.swtvap.api.order.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.OrderTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderTransactionService {
    Flux<OrderTransaction> findAll();

    Mono<OrderTransaction> findById(Long id);

    Mono<OrderTransaction> save(OrderTransaction orderTransaction);

    Mono<Void> deleteById(Long id);

    Flux<OrderTransaction> findByOrderCode(String orderCode);
}
