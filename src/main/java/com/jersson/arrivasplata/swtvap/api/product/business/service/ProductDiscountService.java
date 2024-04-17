package com.jersson.arrivasplata.swtvap.api.product.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductDiscount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductDiscountService {

    Flux<ProductDiscount> findAll();

    Mono<ProductDiscount> findById(Long id);

    Mono<ProductDiscount> save(ProductDiscount productDiscount);

    Mono<Void> deleteById(Long id);

    Flux<ProductDiscount> findByProductName(String productName);
}
