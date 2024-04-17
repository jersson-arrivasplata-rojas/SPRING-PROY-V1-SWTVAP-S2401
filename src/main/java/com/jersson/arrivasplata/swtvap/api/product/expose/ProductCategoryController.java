package com.jersson.arrivasplata.swtvap.api.product.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductCategory;
import reactor.core.publisher.Mono;

public interface ProductCategoryController {
    Mono<ProductCategory> getProductCategoryById(Long id);

    Mono<ProductCategory> createProductCategory(ProductCategory productCategory);

    Mono<ProductCategory> updateProductCategory(Long id, ProductCategory updatedProductCategory);

    Mono<Void> deleteProductCategory(Long id);

}
