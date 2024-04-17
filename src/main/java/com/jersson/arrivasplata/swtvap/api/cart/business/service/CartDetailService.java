package com.jersson.arrivasplata.swtvap.api.cart.business.service;

import com.jersson.arrivasplata.swtvap.api.cart.model.CartDetail;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CartDetailService {

    Flux<CartDetail> findAll();

    Mono<CartDetail> findById(Long id);

    Mono<CartDetail> save(CartDetail cartDetail);

    Mono<Void> deleteById(Long id);

    Flux<CartDetail> findByProductName(String productName);
}
