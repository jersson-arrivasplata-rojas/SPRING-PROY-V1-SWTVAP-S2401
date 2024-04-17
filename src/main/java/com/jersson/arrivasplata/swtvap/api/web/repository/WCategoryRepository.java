package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.model.WCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WCategoryRepository extends JpaRepository<WCategory, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
    WCategory findByName(String name);
}
