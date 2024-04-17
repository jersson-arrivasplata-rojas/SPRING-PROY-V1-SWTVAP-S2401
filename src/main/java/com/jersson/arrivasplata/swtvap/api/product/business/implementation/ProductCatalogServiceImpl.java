package com.jersson.arrivasplata.swtvap.api.product.business.implementation;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductCatalogService;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductCatalog;
import com.jersson.arrivasplata.swtvap.api.product.repository.ProductCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {
    private final ProductCatalogRepository productCatalogRepository;

    @Autowired
    public ProductCatalogServiceImpl(ProductCatalogRepository productCatalogRepository) {
        this.productCatalogRepository = productCatalogRepository;
    }


    public Flux<ProductCatalog> findAll() {
        return Flux.fromIterable(productCatalogRepository.findAll());
    }

    public Mono<ProductCatalog> findById(Long id) {
        return Mono.justOrEmpty(productCatalogRepository.findById(id));
    }

    public Mono<ProductCatalog> save(ProductCatalog productCatalog) {
        return Mono.justOrEmpty(productCatalogRepository.save(productCatalog));
    }

    public Mono<Void> deleteById(Long id) {
        productCatalogRepository.deleteById(id);
        return Mono.empty();
    }

    public Flux<ProductCatalog> findByProductName(String productName) {
        return Flux.fromIterable(productCatalogRepository.findByProductName(productName));
    }

    // Otros métodos que puedas necesitar
}
