package com.jersson.arrivasplata.swtvap.api.inventory.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
    Unit findByUnitName(String name);
}