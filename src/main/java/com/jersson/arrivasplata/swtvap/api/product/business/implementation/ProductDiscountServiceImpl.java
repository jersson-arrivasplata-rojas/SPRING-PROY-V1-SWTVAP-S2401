package com.jersson.arrivasplata.swtvap.api.product.business.implementation;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductDiscountService;
import com.jersson.arrivasplata.swtvap.api.product.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductDiscount;
import com.jersson.arrivasplata.swtvap.api.product.repository.ProductDiscountRepository;
import com.jersson.arrivasplata.swtvap.api.product.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class ProductDiscountServiceImpl implements ProductDiscountService {
    private final ProductDiscountRepository productDiscountRepository;

    @Autowired
    public ProductDiscountServiceImpl(ProductDiscountRepository productDiscountRepository) {
        this.productDiscountRepository = productDiscountRepository;
    }


    public Flux<ProductDiscount> findAll() {
        return Flux.fromIterable(productDiscountRepository.findAll());
    }

    public Mono<ProductDiscount> findById(Long id) {
        return Mono.justOrEmpty(productDiscountRepository.findById(id));
    }

    public Mono<ProductDiscount> save(ProductDiscount productDiscount) {
        return Mono.justOrEmpty(productDiscountRepository.save(productDiscount));
    }

    public Mono<Void> deleteById(Long id) {
        // Lógica para eliminar un product discount
        Optional<ProductDiscount> productDiscountOptional = productDiscountRepository.findById(id);
        if (!productDiscountOptional.isPresent()) {
            throw new CustomException("Catalog not found with id: " + id);
        }
        // Resto de la lógica para eliminar un product Discount
        ProductDiscount productDiscount = productDiscountOptional.get();
        productDiscount.setDeletedAt(Common.builder().build().getCurrentDate());
        productDiscountRepository.save(productDiscount);
        return Mono.empty();
    }

    public Flux<ProductDiscount> findByProductName(String productName) {
        return Flux.fromIterable(productDiscountRepository.findByProductName(productName));
    }

    // Otros métodos que puedas necesitar
}
