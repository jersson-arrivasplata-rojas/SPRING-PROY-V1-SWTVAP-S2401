package com.jersson.arrivasplata.swtvap.api.setting.repository;

import com.jersson.arrivasplata.swtvap.api.setting.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterRepository extends JpaRepository<Parameter, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
}
