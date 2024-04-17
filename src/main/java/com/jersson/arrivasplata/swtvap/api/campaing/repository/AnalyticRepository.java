package com.jersson.arrivasplata.swtvap.api.campaing.repository;

import com.jersson.arrivasplata.swtvap.api.campaing.model.Analytic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalyticRepository extends JpaRepository<Analytic, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
}

