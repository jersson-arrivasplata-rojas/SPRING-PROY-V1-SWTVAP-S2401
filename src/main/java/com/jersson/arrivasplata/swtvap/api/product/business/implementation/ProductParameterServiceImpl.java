package com.jersson.arrivasplata.swtvap.api.product.business.implementation;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductParameterService;
import com.jersson.arrivasplata.swtvap.api.product.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductParameter;
import com.jersson.arrivasplata.swtvap.api.product.repository.ProductParameterRepository;
import com.jersson.arrivasplata.swtvap.api.product.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class ProductParameterServiceImpl implements ProductParameterService {
    private final ProductParameterRepository productParameterRepository;

    @Autowired
    public ProductParameterServiceImpl(ProductParameterRepository productParameterRepository) {
        this.productParameterRepository = productParameterRepository;
    }


    public Flux<ProductParameter> findAll() {
        return Flux.fromIterable(productParameterRepository.findAll());
    }

    public Mono<ProductParameter> findById(Long id) {
        return Mono.justOrEmpty(productParameterRepository.findById(id));
    }

    public Mono<ProductParameter> save(ProductParameter productParameter) {
        return Mono.justOrEmpty(productParameterRepository.save(productParameter));
    }

    public Mono<Void> deleteById(Long id) {

        Optional<ProductParameter> productParameterOptional = productParameterRepository.findById(id);
        if (!productParameterOptional.isPresent()) {
            throw new CustomException("ProductParameter not found with id: " + id);
        }
        ProductParameter productParameter = productParameterOptional.get();
        productParameter.setDeletedAt(Common.builder().build().getCurrentDate());
        productParameterRepository.save(productParameter);

        return Mono.empty();
    }

    public Flux<ProductParameter> findByProductName(String productName) {
        return Flux.fromIterable(productParameterRepository.findByProductName(productName));
    }

    // Otros métodos que puedas necesitar
}
