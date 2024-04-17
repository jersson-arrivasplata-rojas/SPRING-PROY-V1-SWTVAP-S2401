package com.jersson.arrivasplata.swtvap.api.product.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductCatalog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductCatalogService {

    Flux<ProductCatalog> findAll();

    Mono<ProductCatalog> findById(Long id);

    Mono<ProductCatalog> save(ProductCatalog productCatalog);

    Mono<Void> deleteById(Long id);

    Flux<ProductCatalog> findByProductName(String productName);
}
