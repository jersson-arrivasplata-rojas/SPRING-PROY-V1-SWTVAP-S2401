package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.model.WReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WReviewRepository extends JpaRepository<WReview, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
}
