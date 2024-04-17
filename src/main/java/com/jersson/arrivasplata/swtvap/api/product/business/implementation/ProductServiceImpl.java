package com.jersson.arrivasplata.swtvap.api.product.business.implementation;

import com.jersson.arrivasplata.swtvap.api.product.business.service.ProductService;
import com.jersson.arrivasplata.swtvap.api.product.enums.Status;
import com.jersson.arrivasplata.swtvap.api.product.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.common.model.Product;
import com.jersson.arrivasplata.swtvap.api.product.repository.ProductRepository;
import com.jersson.arrivasplata.swtvap.api.product.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> getAllProducts() {
        return Flux.fromIterable(productRepository.findAll());
    }

    public Mono<Product> getProductById(Long id) {
        return Mono.just(productRepository.findById(id)
                .orElseThrow(() -> new CustomException("Product not found with id: " + id)));
    }

    public Mono<Product> createProduct(Product product) {
        // Lógica para crear un nuevo producto
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new CustomException("Product name is required.");
        }
        // Resto de la lógica para crear un producto
        return Mono.just(productRepository.save(product));
    }

    public Mono<Product> updateProduct(Product product) {
        // Lógica para actualizar un producto
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new CustomException("Product name is required.");
        }
        // Resto de la lógica para actualizar un producto
        return Mono.just(productRepository.save(product));
    }

    public Mono<Void> deleteProductById(Long id) {
        // Lógica para eliminar un producto
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new CustomException("Product not found with id: " + id);
        }
        // Resto de la lógica para eliminar un producto

        Product product = productOptional.get();
        product.setStatus(Status.INACTIVE);
        product.setDeletedAt(Common.builder().build().getCurrentDate());
        productRepository.save(product);

        return Mono.empty();
    }

    public Product getProductByName(String name) {
        // Implementación para recuperar el producto por nombre desde el repositorio
        return productRepository.findByName(name);
    }
}