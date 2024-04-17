package com.jersson.arrivasplata.swtvap.api.inventory.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
    Category findByName(String name);
}
