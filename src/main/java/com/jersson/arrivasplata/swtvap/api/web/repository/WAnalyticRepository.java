package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.model.WAnalytic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WAnalyticRepository extends JpaRepository<WAnalytic, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
}

