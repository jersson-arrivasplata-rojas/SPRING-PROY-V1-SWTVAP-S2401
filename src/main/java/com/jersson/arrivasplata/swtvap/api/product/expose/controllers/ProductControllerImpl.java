package com.jersson.arrivasplata.swtvap.api.product.expose.controllers;


import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductService;
import com.jersson.arrivasplata.swtvap.api.product.expose.ProductController;
import com.jersson.arrivasplata.swtvap.api.product.mapper.ProductMapper;
import com.jersson.arrivasplata.swtvap.api.common.model.Product;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/products", produces = "application/vnd.swtvap-api-products.v1+json")
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;


    public ProductControllerImpl(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProductResponse> getAllProducts() {
        return productService.getAllProducts()
                .map(product -> {
                    ProductResponse productResponse = productMapper.productToProductResponse(product);
                    return productResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductResponse> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(product -> {
                    ProductResponse productResponse = productMapper.productToProductResponse(product);
                    return productResponse;

                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        Product product = productMapper.productRequestToProduct(productRequest);

        return productService.createProduct(product)
                .map(newProduct -> {
                    ProductResponse productResponse = productMapper.productToProductResponse(newProduct);
                    return productResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        Product product = productMapper.productRequestToProduct(productRequest);
        product.setProductId(id);
        return productService.updateProduct(product)
                .map(updatedProduct -> {
                    ProductResponse productResponse = productMapper.productToProductResponse(updatedProduct);
                    return productResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return productService.deleteProductById(id);
    }

    // Implementa otros métodos del controlador si es necesario
}