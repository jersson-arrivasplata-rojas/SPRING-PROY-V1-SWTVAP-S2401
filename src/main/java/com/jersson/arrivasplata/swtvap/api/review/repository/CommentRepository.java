package com.jersson.arrivasplata.swtvap.api.review.repository;

import com.jersson.arrivasplata.swtvap.api.review.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
}
