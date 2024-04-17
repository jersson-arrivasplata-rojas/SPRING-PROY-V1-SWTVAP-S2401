package com.jersson.arrivasplata.swtvap.api.product.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductDiscount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDiscountRepository extends JpaRepository<ProductDiscount, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios

    List<ProductDiscount> findAll(); // Obtiene todos los registros

    void deleteById(Long id); // Elimina por ID

    List<ProductDiscount> findByProductName(String productName); // Busca por nombre de producto
}

