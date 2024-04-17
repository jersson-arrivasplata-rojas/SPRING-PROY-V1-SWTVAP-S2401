package com.jersson.arrivasplata.swtvap.api.product.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductProvider;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductProviderService {

    Flux<ProductProvider> findAll();

    Mono<ProductProvider> findById(Long id);

    Mono<ProductProvider> save(ProductProvider productProvider);

    Mono<Void> deleteById(Long id);

    Flux<ProductProvider> findByProductName(String productName);
}
