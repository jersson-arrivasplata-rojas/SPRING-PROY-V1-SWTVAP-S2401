package com.jersson.arrivasplata.swtvap.api.product.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductCatalogService;
import com.jersson.arrivasplata.swtvap.api.product.expose.ProductCatalogController;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductCatalog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/product-catalogs", produces = "application/vnd.swtvap-api-product-catalogs.v1+json")
public class ProductCatalogControllerImpl implements ProductCatalogController {
    private final ProductCatalogService productCatalogService;

    public ProductCatalogControllerImpl(ProductCatalogService productCatalogService) {
        this.productCatalogService = productCatalogService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProductCatalog> getAllProductCatalogs() {
        return productCatalogService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductCatalog> getProductCatalogById(@PathVariable Long id) {
        return productCatalogService.findById(id)
                .map(productCatalog -> productCatalog);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductCatalog> createProductCatalog(@RequestBody ProductCatalog productCatalog) {
        return productCatalogService.save(productCatalog)
                .map(newProductCatalog -> newProductCatalog);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductCatalog> updateProductCatalog(@PathVariable Long id, @RequestBody ProductCatalog updatedProductCatalog) {
        return productCatalogService.findById(id)
                .flatMap(existingProductCategory -> {
                    updatedProductCatalog.setId(id);
                    return productCatalogService.save(updatedProductCatalog);
                })
                .map(updated -> updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProductCatalog(@PathVariable Long id) {
        return productCatalogService.findById(id)
                .flatMap(existingProductCategory -> {
                    productCatalogService.deleteById(id);
                    return Mono.empty();
                });
    }
}
