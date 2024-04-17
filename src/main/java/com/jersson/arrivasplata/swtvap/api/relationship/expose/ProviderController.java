package com.jersson.arrivasplata.swtvap.api.relationship.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.ProviderRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.ProviderResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProviderController {
    Flux<ProviderResponse> getAllProviders();
    Mono<ProviderResponse> getProviderById(Long id);
    Mono<ProviderResponse> createProvider(ProviderRequest providerRequest);
    Mono<ProviderResponse> updateProvider(Long id, ProviderRequest providerRequest);
    Mono<Void> deleteProvider(Long id);
    Mono<ResponseEntity<String>> performUsefulOperationWithResponse();
}
