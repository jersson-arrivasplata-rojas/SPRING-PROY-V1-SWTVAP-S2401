package com.jersson.arrivasplata.swtvap.api.campaing.business.service;

import com.jersson.arrivasplata.swtvap.api.campaing.model.NewsletterSubscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NewsletterSubscriptionService {
    Flux<NewsletterSubscription> getAllNewsletterSubscriptions();
    Mono<NewsletterSubscription> getNewsletterSubscriptionById(Long id);
    Mono<NewsletterSubscription> createNewsletterSubscription(NewsletterSubscription newsletterSubscription);
    Mono<NewsletterSubscription> updateNewsletterSubscription(NewsletterSubscription newsletterSubscription);
    Mono<Void> deleteNewsletterSubscriptionById(Long id);
    // Otros métodos relacionados con producto usando Reactor Core
}
