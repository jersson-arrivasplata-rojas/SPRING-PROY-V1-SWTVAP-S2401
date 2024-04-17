package com.jersson.arrivasplata.swtvap.api.product.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductCategory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductCategoryService {

    Flux<ProductCategory> findAll();

    Mono<ProductCategory> findById(Long id);

    Mono<ProductCategory> save(ProductCategory productCategory);

    Mono<Void> deleteById(Long id);

    Flux<ProductCategory> findByProductName(String productName);
}
