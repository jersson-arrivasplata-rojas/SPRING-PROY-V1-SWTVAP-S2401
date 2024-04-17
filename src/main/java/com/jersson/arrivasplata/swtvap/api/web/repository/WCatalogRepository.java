package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.model.WCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WCatalogRepository extends JpaRepository<WCatalog, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
    WCatalog findByName(String name);

    List<WCatalog> findAll();

    List<WCatalog> findAllByCode(String code);
}

