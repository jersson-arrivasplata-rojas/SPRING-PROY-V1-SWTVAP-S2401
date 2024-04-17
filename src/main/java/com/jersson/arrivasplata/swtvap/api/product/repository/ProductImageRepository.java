package com.jersson.arrivasplata.swtvap.api.product.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios

    List<ProductImage> findAll(); // Obtiene todos los registros

    void deleteById(Long id); // Elimina por ID

    List<ProductImage> findByProductName(String productName); // Busca por nombre de producto
}

