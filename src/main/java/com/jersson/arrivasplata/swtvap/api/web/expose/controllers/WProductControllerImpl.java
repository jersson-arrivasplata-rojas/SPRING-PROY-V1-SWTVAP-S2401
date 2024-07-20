package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WProductService;
import com.jersson.arrivasplata.swtvap.api.web.expose.WProductController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.WProductMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.WProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/w-products", produces = "application/vnd.swtvap-api-w-products.v1+json")
public class WProductControllerImpl implements WProductController {
    private final WProductService productService;
    private final WProductMapper productMapper;


    public WProductControllerImpl(WProductService productService, WProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<WProductResponse> getAllProducts() {
        return productService.getAllProducts()
                .map(product -> {
                    WProductResponse productResponse = productMapper.productToProductResponse(product);
                    return productResponse;
                });
    }

    @GetMapping("/name/{name}/lang/{lang}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<WProductResponse> getProductByName(@PathVariable String name, @PathVariable String lang) {
        return productService.getProductByName(name, lang.toUpperCase())
                .map(product -> {
                    WProductResponse productResponse = productMapper.productToProductResponse(product);
                    return productResponse;
                });
    }

    @GetMapping("/path/{path}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<WProductResponse> getProductByPath(@PathVariable String path) {
        return productService.getProductByPath(path)
                .map(product -> {
                    WProductResponse productResponse = productMapper.productToProductResponse(product);
                    return productResponse;
                });
    }
}
