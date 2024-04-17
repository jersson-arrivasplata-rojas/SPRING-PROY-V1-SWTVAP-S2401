package com.jersson.arrivasplata.swtvap.api.campaing.repository;

import com.jersson.arrivasplata.swtvap.api.campaing.model.NewsletterSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsletterSubscriptionRepository extends JpaRepository<NewsletterSubscription, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
}

