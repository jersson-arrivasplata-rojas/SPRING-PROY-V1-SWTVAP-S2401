package com.jersson.arrivasplata.swtvap.api.web.business.service;

import com.jersson.arrivasplata.swtvap.api.web.model.WNewsletterSubscription;
import reactor.core.publisher.Mono;

public interface WNewsletterSubscriptionService {
    Mono<WNewsletterSubscription> createNewsletterSubscription(WNewsletterSubscription newsletterSubscription);
    // Otros métodos relacionados con producto usando Reactor Core
}
