package com.jersson.arrivasplata.swtvap.api.relationship.business.implementation;

import com.jersson.arrivasplata.swtvap.api.relationship.business.service.ProviderService;
import com.jersson.arrivasplata.swtvap.api.relationship.enums.Status;
import com.jersson.arrivasplata.swtvap.api.relationship.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.common.model.Provider;
import com.jersson.arrivasplata.swtvap.api.relationship.repository.ProviderRepository;
import com.jersson.arrivasplata.swtvap.api.relationship.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository){
        this.providerRepository = providerRepository;
    }


    @Override
    public Flux<Provider> getAllProviders() {
        return Flux.fromIterable(providerRepository.findAll());
    }

    @Override
    public Mono<Provider> getProviderById(Long id) {
        return Mono.just(providerRepository.findById(id)
                .orElseThrow(() -> new CustomException("Provider not found with id: " + id)));
    }

    @Override
    public Mono<Provider> createProvider(Provider provider) {   //Crear proveedor
        if (provider.getName() == null || provider.getName().isEmpty()) {
            throw new CustomException("Provider name is required");
        }
        return Mono.just(providerRepository.save(provider));
    }

    @Override
    public Mono<Provider> updateProvider(Provider provider) { //Actualizar proveedor
        if (provider.getName() == null || provider.getName().isEmpty()) {
            throw new CustomException("Provider name is required.");
        }
        return Mono.just(providerRepository.save(provider));
    }

    @Override
    public Mono<Void> deleteProviderbyId(Long id) {
        Optional<Provider> providerOptional = providerRepository.findById(id);
        if (!providerOptional.isPresent()) {
            throw new CustomException("Provider not found with id: " + id);
        }
        // Resto de la lógica para eliminar un provider
        Provider provider = providerOptional.get();
        provider.setStatus(Status.INACTIVE);
        provider.setDeletedAt(Common.builder().build().getCurrentDate());
        providerRepository.save(provider);

        return Mono.empty();
    }

    public Provider getProviderByName(String name){
        return providerRepository.findByName(name);
    }
}
