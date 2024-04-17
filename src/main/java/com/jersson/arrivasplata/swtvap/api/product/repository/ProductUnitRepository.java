package com.jersson.arrivasplata.swtvap.api.product.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductUnitRepository extends JpaRepository<ProductUnit, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios

    List<ProductUnit> findAll(); // Obtiene todos los registros

    void deleteById(Long id); // Elimina por ID

    List<ProductUnit> findByProductName(String productName); // Busca por nombre de producto
}

