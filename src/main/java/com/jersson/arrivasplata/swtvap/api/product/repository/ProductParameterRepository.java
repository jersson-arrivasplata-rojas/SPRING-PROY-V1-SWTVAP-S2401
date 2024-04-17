package com.jersson.arrivasplata.swtvap.api.product.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductParameterRepository extends JpaRepository<ProductParameter, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios

    List<ProductParameter> findAll(); // Obtiene todos los registros

    void deleteById(Long id); // Elimina por ID

    List<ProductParameter> findByProductName(String productName); // Busca por nombre de producto
}

