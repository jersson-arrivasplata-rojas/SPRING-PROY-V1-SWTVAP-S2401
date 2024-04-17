package com.jersson.arrivasplata.swtvap.api.web.repository;


import com.jersson.arrivasplata.swtvap.api.web.model.WContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WContactRepository extends JpaRepository<WContact, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
}
