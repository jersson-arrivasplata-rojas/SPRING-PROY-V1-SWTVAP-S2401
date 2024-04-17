package com.jersson.arrivasplata.swtvap.api.product.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductImage;
import reactor.core.publisher.Mono;

public interface ProductImageController {
    Mono<ProductImage> getProductImageById(Long id);

    Mono<ProductImage> createProductImage(ProductImage productImage);

    Mono<ProductImage> updateProductImage(Long id, ProductImage updatedProductImage);

    Mono<Void> deleteProductImage(Long id);

}
