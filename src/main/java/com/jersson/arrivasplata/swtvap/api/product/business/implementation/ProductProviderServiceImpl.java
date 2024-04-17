package com.jersson.arrivasplata.swtvap.api.product.business.implementation;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductProviderService;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductProvider;
import com.jersson.arrivasplata.swtvap.api.product.repository.ProductProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductProviderServiceImpl implements ProductProviderService {
    private final ProductProviderRepository productProviderRepository;

    @Autowired
    public ProductProviderServiceImpl(ProductProviderRepository productProviderRepository) {
        this.productProviderRepository = productProviderRepository;
    }


    public Flux<ProductProvider> findAll() {
        return Flux.fromIterable(productProviderRepository.findAll());
    }

    public Mono<ProductProvider> findById(Long id) {
        return Mono.justOrEmpty(productProviderRepository.findById(id));
    }

    public Mono<ProductProvider> save(ProductProvider productProvider) {
        return Mono.justOrEmpty(productProviderRepository.save(productProvider));
    }

    public Mono<Void> deleteById(Long id) {
        productProviderRepository.deleteById(id);
        return Mono.empty();
    }

    public Flux<ProductProvider> findByProductName(String productName) {
        return Flux.fromIterable(productProviderRepository.findByProductName(productName));
    }

    // Otros métodos que puedas necesitar
}
