package com.jersson.arrivasplata.swtvap.api.product.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductImageService;
import com.jersson.arrivasplata.swtvap.api.product.expose.ProductImageController;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductImage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/product-images", produces = "application/vnd.swtvap-api-product-images.v1+json")
public class ProductImageControllerImpl implements ProductImageController {
    private final ProductImageService productImageService;

    public ProductImageControllerImpl(ProductImageService productImageService) {
        this.productImageService = productImageService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProductImage> getAllProductImages() {
        return productImageService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductImage> getProductImageById(@PathVariable Long id) {
        return productImageService.findById(id)
                .map(productImage -> productImage);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductImage> createProductImage(@RequestBody ProductImage productImage) {
        return productImageService.save(productImage)
                .map(newProductImage -> newProductImage);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductImage> updateProductImage(@PathVariable Long id, @RequestBody ProductImage updatedProductImage) {
        return productImageService.findById(id)
                .flatMap(existingProductImage -> {
                    updatedProductImage.setProductImageId(id);
                    return productImageService.save(updatedProductImage);
                })
                .map(updated -> updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProductImage(@PathVariable Long id) {
        return productImageService.findById(id)
                .flatMap(existingProductImage -> {
                    productImageService.deleteById(id);
                    return Mono.empty();
                });
    }
}
