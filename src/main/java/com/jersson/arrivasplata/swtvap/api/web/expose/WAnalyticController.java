package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.WAnalyticRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WAnalyticResponse;
import reactor.core.publisher.Mono;

public interface WAnalyticController {
    Mono<WAnalyticResponse> createAnalytic(WAnalyticRequest analyticRequest);
    // Otros métodos relacionados con analytico usando Reactor Core
}
