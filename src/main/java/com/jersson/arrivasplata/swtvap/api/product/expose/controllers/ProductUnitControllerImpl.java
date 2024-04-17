package com.jersson.arrivasplata.swtvap.api.product.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductUnitService;
import com.jersson.arrivasplata.swtvap.api.product.expose.ProductUnitController;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductUnit;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/product-units", produces = "application/vnd.swtvap-api-product-units.v1+json")
public class ProductUnitControllerImpl implements ProductUnitController {
    private final ProductUnitService productUnitService;

    public ProductUnitControllerImpl(ProductUnitService productUnitService) {
        this.productUnitService = productUnitService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProductUnit> getAllProductUnits() {
        return productUnitService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductUnit> getProductUnitById(@PathVariable Long id) {
        return productUnitService.findById(id)
                .map(productUnit -> productUnit);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductUnit> createProductUnit(@RequestBody ProductUnit productUnit) {
        return productUnitService.save(productUnit)
                .map(newProductUnit -> newProductUnit);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductUnit> updateProductUnit(@PathVariable Long id, @RequestBody ProductUnit updatedProductUnit) {
        return productUnitService.findById(id)
                .flatMap(existingProductUnit -> {
                    updatedProductUnit.setId(id);
                    return productUnitService.save(updatedProductUnit);
                })
                .map(updated -> updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProductUnit(@PathVariable Long id) {
        return productUnitService.findById(id)
                .flatMap(existingProductUnit -> {
                    productUnitService.deleteById(id);
                    return Mono.empty();
                });
    }
}
