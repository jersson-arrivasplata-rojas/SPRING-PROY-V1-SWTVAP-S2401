package com.jersson.arrivasplata.swtvap.api.inventory.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
    Catalog findByName(String name);
}

