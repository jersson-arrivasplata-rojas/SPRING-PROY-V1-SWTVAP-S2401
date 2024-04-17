package com.jersson.arrivasplata.swtvap.api.product.business.implementation;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductImageService;
import com.jersson.arrivasplata.swtvap.api.product.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductImage;
import com.jersson.arrivasplata.swtvap.api.product.repository.ProductImageRepository;
import com.jersson.arrivasplata.swtvap.api.product.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    private final ProductImageRepository productImageRepository;

    @Autowired
    public ProductImageServiceImpl(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }


    public Flux<ProductImage> findAll() {
        return Flux.fromIterable(productImageRepository.findAll());
    }

    public Mono<ProductImage> findById(Long id) {
        return Mono.justOrEmpty(productImageRepository.findById(id));
    }

    public Mono<ProductImage> save(ProductImage productImage) {
        return Mono.justOrEmpty(productImageRepository.save(productImage));
    }

    public Mono<Void> deleteById(Long id) {

        Optional<ProductImage> productImageOptional = productImageRepository.findById(id);
        if (!productImageOptional.isPresent()) {
            throw new CustomException("Client not found with id: " + id);
        }
        // Resto de la lógica para eliminar un client
        ProductImage productImage = productImageOptional.get();
        productImage.setDeletedAt(Common.builder().build().getCurrentDate());
        productImageRepository.save(productImage);

        return Mono.empty();
    }

    public Flux<ProductImage> findByProductName(String productName) {
        return Flux.fromIterable(productImageRepository.findByProductName(productName));
    }

    // Otros métodos que puedas necesitar
}
