package com.jersson.arrivasplata.swtvap.api.product.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductCatalog;
import reactor.core.publisher.Mono;

public interface ProductCatalogController {
    Mono<ProductCatalog> getProductCatalogById(Long id);

    Mono<ProductCatalog> createProductCatalog(ProductCatalog productCatalog);

    Mono<ProductCatalog> updateProductCatalog(Long id, ProductCatalog updatedProductCatalog);

    Mono<Void> deleteProductCatalog(Long id);

}
