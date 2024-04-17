package com.jersson.arrivasplata.swtvap.api.logistic.expose;

import com.jersson.arrivasplata.swtvap.api.logistic.model.DispatchesRequest;
import com.jersson.arrivasplata.swtvap.api.logistic.model.DispatchesResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DispatchesController {

    Flux<DispatchesResponse> getAllDispatches();
    Mono<DispatchesResponse> getDispatchesById(Long id);
    Mono<DispatchesResponse> createDispatches(DispatchesRequest dispatchesRequest);
    Mono<DispatchesResponse> updateDispatches(Long id, DispatchesRequest dispatchesRequest);
    Mono<Void> deleteDispatches(Long id);
}
