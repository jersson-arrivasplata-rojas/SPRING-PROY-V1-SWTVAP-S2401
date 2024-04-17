package com.jersson.arrivasplata.swtvap.api.product.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios

    List<ProductCategory> findAll(); // Obtiene todos los registros

    void deleteById(Long id); // Elimina por ID

    List<ProductCategory> findByProductName(String productName); // Busca por nombre de producto

    @Transactional
    void deleteByCategoryCategoryId(Long categoryId); // Elimina todas los catalogos con un category id específico
}

