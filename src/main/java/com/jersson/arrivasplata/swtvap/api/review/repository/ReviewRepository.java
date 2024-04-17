package com.jersson.arrivasplata.swtvap.api.review.repository;

import com.jersson.arrivasplata.swtvap.api.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
}
