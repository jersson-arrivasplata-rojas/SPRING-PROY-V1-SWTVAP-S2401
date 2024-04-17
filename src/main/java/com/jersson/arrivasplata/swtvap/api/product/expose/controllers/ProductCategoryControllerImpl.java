package com.jersson.arrivasplata.swtvap.api.product.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductCategoryService;
import com.jersson.arrivasplata.swtvap.api.product.expose.ProductCategoryController;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductCategory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/product-categories", produces = "application/vnd.swtvap-api-product-categories.v1+json")
public class ProductCategoryControllerImpl implements ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    public ProductCategoryControllerImpl(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProductCategory> getAllProductCategorys() {
        return productCategoryService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductCategory> getProductCategoryById(@PathVariable Long id) {
        return productCategoryService.findById(id)
                .map(productCategory -> productCategory);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductCategory> createProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.save(productCategory)
                .map(newProductCategory -> newProductCategory);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductCategory> updateProductCategory(@PathVariable Long id, @RequestBody ProductCategory updatedProductCategory) {
        return productCategoryService.findById(id)
                .flatMap(existingProductCategory -> {
                    updatedProductCategory.setId(id);
                    return productCategoryService.save(updatedProductCategory);
                })
                .map(updated -> updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProductCategory(@PathVariable Long id) {
        return productCategoryService.findById(id)
                .flatMap(existingProductCategory -> {
                    productCategoryService.deleteById(id);
                    return Mono.empty();
                });
    }
}
