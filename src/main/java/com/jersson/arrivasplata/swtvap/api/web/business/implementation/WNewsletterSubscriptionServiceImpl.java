package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WNewsletterSubscriptionService;
import com.jersson.arrivasplata.swtvap.api.web.model.WNewsletterSubscription;
import com.jersson.arrivasplata.swtvap.api.web.repository.WNewsletterSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WNewsletterSubscriptionServiceImpl implements WNewsletterSubscriptionService {

    private final WNewsletterSubscriptionRepository WNewsletterSubscriptionRepository;

    @Autowired
    public WNewsletterSubscriptionServiceImpl(WNewsletterSubscriptionRepository WNewsletterSubscriptionRepository) {
        this.WNewsletterSubscriptionRepository = WNewsletterSubscriptionRepository;
    }

    public Mono<WNewsletterSubscription> createNewsletterSubscription(WNewsletterSubscription newsletterSubscription) {
        // Lógica para crear un nuevo newsletterSubscription
        return Mono.just(WNewsletterSubscriptionRepository.save(newsletterSubscription));
    }
}