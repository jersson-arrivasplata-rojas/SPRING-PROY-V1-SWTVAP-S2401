package com.jersson.arrivasplata.swtvap.api.product.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductProvider;
import reactor.core.publisher.Mono;

public interface ProductProviderController {
    Mono<ProductProvider> getProductProviderById(Long id);

    Mono<ProductProvider> createProductProvider(ProductProvider productProvider);

    Mono<ProductProvider> updateProductProvider(Long id, ProductProvider updatedProductProvider);

    Mono<Void> deleteProductProvider(Long id);
}
