package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.model.WNewsletterSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WNewsletterSubscriptionRepository extends JpaRepository<WNewsletterSubscription, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
}

