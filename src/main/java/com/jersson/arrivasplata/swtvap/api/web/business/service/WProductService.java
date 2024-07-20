package com.jersson.arrivasplata.swtvap.api.web.business.service;

import com.jersson.arrivasplata.swtvap.api.web.model.WProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface WProductService {
    Flux<WProduct> getAllProducts();
    Mono<WProduct> getProductByName(String name, String lang);
    Mono<WProduct> getProductByPath(String path);
}
