package com.jersson.arrivasplata.swtvap.api.product.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductParameter;
import reactor.core.publisher.Mono;

public interface ProductParameterController {
    Mono<ProductParameter> getProductParameterById(Long id);

    Mono<ProductParameter> createProductParameter(ProductParameter productParameter);

    Mono<ProductParameter> updateProductParameter(Long id, ProductParameter updatedProductParameter);

    Mono<Void> deleteProductParameter(Long id);

}
