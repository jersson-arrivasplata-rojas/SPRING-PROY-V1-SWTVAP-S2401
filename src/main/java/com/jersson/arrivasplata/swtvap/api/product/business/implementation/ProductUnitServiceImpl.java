package com.jersson.arrivasplata.swtvap.api.product.business.implementation;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductUnitService;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductUnit;
import com.jersson.arrivasplata.swtvap.api.product.repository.ProductUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductUnitServiceImpl implements ProductUnitService {
    private final ProductUnitRepository productUnitRepository;

    @Autowired
    public ProductUnitServiceImpl(ProductUnitRepository productUnitRepository) {
        this.productUnitRepository = productUnitRepository;
    }


    public Flux<ProductUnit> findAll() {
        return Flux.fromIterable(productUnitRepository.findAll());
    }

    public Mono<ProductUnit> findById(Long id) {
        return Mono.justOrEmpty(productUnitRepository.findById(id));
    }

    public Mono<ProductUnit> save(ProductUnit productUnit) {
        return Mono.justOrEmpty(productUnitRepository.save(productUnit));
    }

    public Mono<Void> deleteById(Long id) {
        productUnitRepository.deleteById(id);

        return Mono.empty();
    }

    public Flux<ProductUnit> findByProductName(String productName) {
        return Flux.fromIterable(productUnitRepository.findByProductName(productName));
    }

    // Otros métodos que puedas necesitar
}
