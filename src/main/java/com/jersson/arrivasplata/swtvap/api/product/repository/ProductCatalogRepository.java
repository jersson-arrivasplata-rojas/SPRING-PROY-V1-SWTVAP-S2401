package com.jersson.arrivasplata.swtvap.api.product.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.ProductCatalog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios

    List<ProductCatalog> findAll(); // Obtiene todos los registros

    void deleteById(Long id); // Elimina por ID

    List<ProductCatalog> findByProductName(String productName); // Busca por nombre de producto

    @Transactional
    void deleteByCatalogCatalogId(Long catalogId); // Elimina todas los catalogos con un category id específico
}

