package com.jersson.arrivasplata.swtvap.api.relationship.business.service;
import com.jersson.arrivasplata.swtvap.api.common.model.Provider;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProviderService {
    Flux<Provider> getAllProviders();
    Mono<Provider> getProviderById(Long id);
    Mono<Provider> createProvider(Provider provider);
    Mono<Provider> updateProvider(Provider provider);
    Mono<Void> deleteProviderbyId(Long id);
}
