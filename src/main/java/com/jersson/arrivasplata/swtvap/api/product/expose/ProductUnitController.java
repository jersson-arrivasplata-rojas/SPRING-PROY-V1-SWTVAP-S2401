package com.jersson.arrivasplata.swtvap.api.product.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductUnit;
import reactor.core.publisher.Mono;

public interface ProductUnitController {
    Mono<ProductUnit> getProductUnitById(Long id);

    Mono<ProductUnit> createProductUnit(ProductUnit productUnit);

    Mono<ProductUnit> updateProductUnit(Long id, ProductUnit updatedProductUnit);

    Mono<Void> deleteProductUnit(Long id);
}
