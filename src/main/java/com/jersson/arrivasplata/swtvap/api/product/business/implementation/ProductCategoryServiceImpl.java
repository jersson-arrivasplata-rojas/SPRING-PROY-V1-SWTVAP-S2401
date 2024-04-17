package com.jersson.arrivasplata.swtvap.api.product.business.implementation;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductCategoryService;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductCategory;
import com.jersson.arrivasplata.swtvap.api.product.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }


    public Flux<ProductCategory> findAll() {
        return Flux.fromIterable(productCategoryRepository.findAll());
    }

    public Mono<ProductCategory> findById(Long id) {
        return Mono.justOrEmpty(productCategoryRepository.findById(id));
    }

    public Mono<ProductCategory> save(ProductCategory productCategory) {
        return Mono.justOrEmpty(productCategoryRepository.save(productCategory));
    }

    public Mono<Void> deleteById(Long id) {
        productCategoryRepository.deleteById(id);
        return Mono.empty();
    }

    public Flux<ProductCategory> findByProductName(String productName) {
        return Flux.fromIterable(productCategoryRepository.findByProductName(productName));
    }

    // Otros métodos que puedas necesitar
}
