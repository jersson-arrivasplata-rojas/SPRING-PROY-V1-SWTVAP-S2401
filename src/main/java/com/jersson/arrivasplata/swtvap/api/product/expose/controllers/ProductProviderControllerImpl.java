package com.jersson.arrivasplata.swtvap.api.product.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductProviderService;
import com.jersson.arrivasplata.swtvap.api.product.expose.ProductProviderController;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductProvider;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/product-providers", produces = "application/vnd.swtvap-api-product-providers.v1+json")
public class ProductProviderControllerImpl implements ProductProviderController {
    private final ProductProviderService productProviderService;

    public ProductProviderControllerImpl(ProductProviderService productProviderService) {
        this.productProviderService = productProviderService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProductProvider> getAllProductProviders() {
        return productProviderService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductProvider> getProductProviderById(@PathVariable Long id) {
        return productProviderService.findById(id)
                .map(productProvider -> productProvider);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductProvider> createProductProvider(@RequestBody ProductProvider productProvider) {
        return productProviderService.save(productProvider)
                .map(newProductProvider -> newProductProvider);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductProvider> updateProductProvider(@PathVariable Long id, @RequestBody ProductProvider updatedProductProvider) {
        return productProviderService.findById(id)
                .flatMap(existingProductProvider -> {
                    updatedProductProvider.setId(id);
                    return productProviderService.save(updatedProductProvider);
                })
                .map(updated -> updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProductProvider(@PathVariable Long id) {
        return productProviderService.findById(id)
                .flatMap(existingProductProvider -> {
                    productProviderService.deleteById(id);
                    return Mono.empty();
                });
    }
}
