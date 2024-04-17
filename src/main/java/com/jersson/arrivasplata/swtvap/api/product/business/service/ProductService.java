package com.jersson.arrivasplata.swtvap.api.product.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> getAllProducts();
    Mono<Product> getProductById(Long id);
    Mono<Product> createProduct(Product product);
    Mono<Product> updateProduct(Product product);
    Mono<Void> deleteProductById(Long id);
    // Otros métodos relacionados con producto usando Reactor Core
}
