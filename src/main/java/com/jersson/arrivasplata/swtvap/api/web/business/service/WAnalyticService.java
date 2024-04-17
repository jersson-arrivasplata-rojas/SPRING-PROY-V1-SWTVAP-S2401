package com.jersson.arrivasplata.swtvap.api.web.business.service;

import com.jersson.arrivasplata.swtvap.api.web.model.WAnalytic;
import reactor.core.publisher.Mono;

public interface WAnalyticService {
    Mono<WAnalytic> createAnalytic(WAnalytic analytic);
    // Otros métodos relacionados con producto usando Reactor Core
}
