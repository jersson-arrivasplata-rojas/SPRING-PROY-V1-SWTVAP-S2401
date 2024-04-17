package com.jersson.arrivasplata.swtvap.api.product.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductController {
    Flux<ProductResponse> getAllProducts();
    Mono<ProductResponse> getProductById(Long id);
    Mono<ProductResponse> createProduct(ProductRequest productRequest);
    Mono<ProductResponse> updateProduct(Long id, ProductRequest productRequest);
    Mono<Void> deleteProduct(Long id);
    // Otros métodos relacionados con producto usando Reactor Core
}
