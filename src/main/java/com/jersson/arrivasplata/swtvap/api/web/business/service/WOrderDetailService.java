package com.jersson.arrivasplata.swtvap.api.web.business.service;

import com.jersson.arrivasplata.swtvap.api.web.model.WOrderDetail;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WOrderDetailService {
    Flux<WOrderDetail> findAll();

    Mono<WOrderDetail> findById(Long id);

    Mono<WOrderDetail> save(WOrderDetail orderDetail);

    Mono<WOrderDetail> updateOrderDetail(WOrderDetail orderDetail);

    Mono<Void> deleteById(Long id);

    Flux<WOrderDetail> findByOrderCode(String orderCode);
}
