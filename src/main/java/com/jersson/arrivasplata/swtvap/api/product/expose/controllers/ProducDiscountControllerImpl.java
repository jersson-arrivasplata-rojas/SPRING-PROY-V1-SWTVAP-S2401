package com.jersson.arrivasplata.swtvap.api.product.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductDiscountService;
import com.jersson.arrivasplata.swtvap.api.product.expose.ProductDiscountController;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductDiscount;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/product-discounts", produces = "application/vnd.swtvap-api-product-discounts.v1+json")
public class ProducDiscountControllerImpl implements ProductDiscountController {
    private final ProductDiscountService productDiscountService;

    public ProducDiscountControllerImpl(ProductDiscountService productDiscountService) {
        this.productDiscountService = productDiscountService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProductDiscount> getAllProductDiscounts() {
        return productDiscountService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductDiscount> getProductDiscountById(@PathVariable Long id) {
        return productDiscountService.findById(id)
                .map(productDiscount -> productDiscount);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductDiscount> createProductDiscount(@RequestBody ProductDiscount productDiscount) {
        return productDiscountService.save(productDiscount)
                .map(newProductDiscount -> newProductDiscount);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductDiscount> updateProductDiscount(@PathVariable Long id, @RequestBody ProductDiscount updatedProductDiscount) {
        return productDiscountService.findById(id)
                .flatMap(existingProductDiscount -> {
                    updatedProductDiscount.setProductDiscountId(id);
                    return productDiscountService.save(updatedProductDiscount);
                })
                .map(updated -> updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProductDiscount(@PathVariable Long id) {
        return productDiscountService.findById(id)
                .flatMap(existingProductDiscount -> {
                    productDiscountService.deleteById(id);
                    return Mono.empty();
                });
    }
}
