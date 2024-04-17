package com.jersson.arrivasplata.swtvap.api.campaing.expose;

import com.jersson.arrivasplata.swtvap.api.campaing.model.NewsletterSubscriptionRequest;
import com.jersson.arrivasplata.swtvap.api.campaing.model.NewsletterSubscriptionResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NewsletterSubscriptionController {
    Flux<NewsletterSubscriptionResponse> getAllNewsletterSubscriptions();
    Mono<NewsletterSubscriptionResponse> getNewsletterSubscriptionById(Long id);
    Mono<NewsletterSubscriptionResponse> createNewsletterSubscription(NewsletterSubscriptionRequest newsletterSubscriptionRequest);
    Mono<NewsletterSubscriptionResponse> updateNewsletterSubscription(Long id, NewsletterSubscriptionRequest newsletterSubscriptionRequest);
    Mono<Void> deleteNewsletterSubscription(Long id);
    // Otros métodos relacionados con newsletterSubscription usando Reactor Core
}
