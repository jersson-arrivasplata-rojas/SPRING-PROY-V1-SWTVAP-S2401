package com.jersson.arrivasplata.swtvap.api.product.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductDiscount;
import reactor.core.publisher.Mono;

public interface ProductDiscountController {
    Mono<ProductDiscount> getProductDiscountById(Long id);

    Mono<ProductDiscount> createProductDiscount(ProductDiscount productDiscount);

    Mono<ProductDiscount> updateProductDiscount(Long id, ProductDiscount updatedProductDiscount);

    Mono<Void> deleteProductDiscount(Long id);

}
