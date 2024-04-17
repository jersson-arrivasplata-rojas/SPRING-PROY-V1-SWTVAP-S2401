package com.jersson.arrivasplata.swtvap.api.logistic.business.service;

import com.jersson.arrivasplata.swtvap.api.logistic.model.Dispatches;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DispatchesService {
    Flux<Dispatches> getAllDispatches();
    Mono<Dispatches> getDispatchesById(Long id);
    Mono<Dispatches> createDispatches(Dispatches dispatches);
    Mono<Dispatches> updateDispatches( Dispatches dispatches);
    Mono<Void> deleteDispatchesById(Long id);
}
