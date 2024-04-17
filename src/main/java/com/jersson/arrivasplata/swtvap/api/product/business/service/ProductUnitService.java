package com.jersson.arrivasplata.swtvap.api.product.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductUnit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductUnitService {

    Flux<ProductUnit> findAll();

    Mono<ProductUnit> findById(Long id);

    Mono<ProductUnit> save(ProductUnit productUnit);

    Mono<Void> deleteById(Long id);

    Flux<ProductUnit> findByProductName(String productName);
}
