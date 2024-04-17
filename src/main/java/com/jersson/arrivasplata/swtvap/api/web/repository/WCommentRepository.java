package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.model.WComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WCommentRepository extends JpaRepository<WComment, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
}
