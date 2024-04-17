package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.WProductResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WProductController {

    Flux<WProductResponse> getAllProducts();

    Mono<WProductResponse> getProductByName(String name, String lang);
}
