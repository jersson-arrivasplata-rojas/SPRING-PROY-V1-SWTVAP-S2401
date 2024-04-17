package com.jersson.arrivasplata.swtvap.api.campaing.expose;

import com.jersson.arrivasplata.swtvap.api.campaing.model.AnalyticRequest;
import com.jersson.arrivasplata.swtvap.api.campaing.model.AnalyticResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AnalyticController {
    Flux<AnalyticResponse> getAllAnalytics();
    Mono<AnalyticResponse> getAnalyticById(Long id);
    Mono<AnalyticResponse> createAnalytic(AnalyticRequest analyticRequest);
    Mono<AnalyticResponse> updateAnalytic(Long id, AnalyticRequest analyticRequest);
    Mono<Void> deleteAnalytic(Long id);
    // Otros métodos relacionados con analytico usando Reactor Core
}
