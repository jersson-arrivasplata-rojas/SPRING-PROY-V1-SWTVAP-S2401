package com.jersson.arrivasplata.swtvap.api.setting.expose;

import com.jersson.arrivasplata.swtvap.api.setting.model.ParameterRequest;
import com.jersson.arrivasplata.swtvap.api.setting.model.ParameterResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParameterController {
    Flux<ParameterResponse> getAllParameters();

    Mono<ParameterResponse> getParameterById(Long id);

    Mono<ParameterResponse> createParameter(ParameterRequest parameter);

    Mono<ParameterResponse> updateParameter(Long id, ParameterRequest updatedParameter);

    Mono<Void> deleteParameter(Long id);
}
