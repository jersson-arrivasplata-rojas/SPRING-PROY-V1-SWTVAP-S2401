package com.jersson.arrivasplata.swtvap.api.product.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductParameterService;
import com.jersson.arrivasplata.swtvap.api.product.expose.ProductParameterController;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductParameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/product-parameters", produces = "application/vnd.swtvap-api-product-parameters.v1+json")
public class ProductParameterControllerImpl implements ProductParameterController {
    private final ProductParameterService productParameterService;

    public ProductParameterControllerImpl(ProductParameterService productParameterService) {
        this.productParameterService = productParameterService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProductParameter> getAllProductParameters() {
        return productParameterService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductParameter> getProductParameterById(@PathVariable Long id) {
        return productParameterService.findById(id)
                .map(productParameter -> productParameter);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductParameter> createProductParameter(@RequestBody ProductParameter productParameter) {
        return productParameterService.save(productParameter)
                .map(newProductParameter -> newProductParameter);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductParameter> updateProductParameter(@PathVariable Long id, @RequestBody ProductParameter updatedProductParameter) {
        return productParameterService.findById(id)
                .flatMap(existingProductParameter -> {
                    updatedProductParameter.setProductParameterId(id);
                    return productParameterService.save(updatedProductParameter);
                })
                .map(updated -> updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProductParameter(@PathVariable Long id) {
        return productParameterService.findById(id)
                .flatMap(existingProductParameter -> {
                    productParameterService.deleteById(id);
                    return Mono.empty();
                });
    }
}
