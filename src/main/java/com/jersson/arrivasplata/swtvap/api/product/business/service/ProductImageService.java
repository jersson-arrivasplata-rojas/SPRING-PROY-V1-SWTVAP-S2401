package com.jersson.arrivasplata.swtvap.api.product.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductImage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductImageService {

    Flux<ProductImage> findAll();

    Mono<ProductImage> findById(Long id);

    Mono<ProductImage> save(ProductImage productImage);

    Mono<Void> deleteById(Long id);

    Flux<ProductImage> findByProductName(String productName);
}
