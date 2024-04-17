package com.jersson.arrivasplata.swtvap.api.product.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductProviderRepository extends JpaRepository<ProductProvider, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios

    List<ProductProvider> findAll(); // Obtiene todos los registros

    void deleteById(Long id); // Elimina por ID

    List<ProductProvider> findByProductName(String productName); // Busca por nombre de producto
}

