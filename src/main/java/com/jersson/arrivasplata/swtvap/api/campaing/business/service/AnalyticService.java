package com.jersson.arrivasplata.swtvap.api.campaing.business.service;

import com.jersson.arrivasplata.swtvap.api.campaing.model.Analytic;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AnalyticService {
    Flux<Analytic> getAllAnalytics();
    Mono<Analytic> getAnalyticById(Long id);
    Mono<Analytic> createAnalytic(Analytic analytic);
    Mono<Analytic> updateAnalytic(Analytic analytic);
    Mono<Void> deleteAnalyticById(Long id);
    // Otros métodos relacionados con producto usando Reactor Core
}
