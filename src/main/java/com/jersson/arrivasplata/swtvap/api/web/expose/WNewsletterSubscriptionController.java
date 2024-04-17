package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.WNewsletterSubscriptionRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WNewsletterSubscriptionResponse;
import reactor.core.publisher.Mono;

public interface WNewsletterSubscriptionController {
    Mono<WNewsletterSubscriptionResponse> createNewsletterSubscription(WNewsletterSubscriptionRequest newsletterSubscriptionRequest);
    // Otros métodos relacionados con newsletterSubscription usando Reactor Core
}
