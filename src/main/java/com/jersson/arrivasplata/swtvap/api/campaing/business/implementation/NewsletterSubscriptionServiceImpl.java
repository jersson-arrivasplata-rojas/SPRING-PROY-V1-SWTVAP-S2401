package com.jersson.arrivasplata.swtvap.api.campaing.business.implementation;

import com.jersson.arrivasplata.swtvap.api.campaing.business.service.NewsletterSubscriptionService;
import com.jersson.arrivasplata.swtvap.api.campaing.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.campaing.model.NewsletterSubscription;
import com.jersson.arrivasplata.swtvap.api.campaing.repository.NewsletterSubscriptionRepository;
import com.jersson.arrivasplata.swtvap.api.campaing.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class NewsletterSubscriptionServiceImpl implements NewsletterSubscriptionService {

    private final NewsletterSubscriptionRepository newsletterSubscriptionRepository;

    @Autowired
    public NewsletterSubscriptionServiceImpl(NewsletterSubscriptionRepository newsletterSubscriptionRepository) {
        this.newsletterSubscriptionRepository = newsletterSubscriptionRepository;
    }

    @Override
    public Flux<NewsletterSubscription> getAllNewsletterSubscriptions() {
        return Flux.fromIterable(newsletterSubscriptionRepository.findAll());
    }

    public Mono<NewsletterSubscription> getNewsletterSubscriptionById(Long id) {
        return Mono.just(newsletterSubscriptionRepository.findById(id)
                .orElseThrow(() -> new CustomException("NewsletterSubscription not found with id: " + id)));
    }

    public Mono<NewsletterSubscription> createNewsletterSubscription(NewsletterSubscription newsletterSubscription) {
        // Lógica para crear un nuevo newsletterSubscription
        return Mono.just(newsletterSubscriptionRepository.save(newsletterSubscription));
    }

    public Mono<NewsletterSubscription> updateNewsletterSubscription(NewsletterSubscription newsletterSubscription) {
        // Lógica para actualizar un newsletterSubscription
        if (newsletterSubscription.getNewsletterSubscriptionId() == null) {
            throw new CustomException("NewsletterSubscription id is required.");
        }
        // Resto de la lógica para actualizar un newsletterSubscription
        return Mono.just(newsletterSubscriptionRepository.save(newsletterSubscription));
    }

    public Mono<Void> deleteNewsletterSubscriptionById(Long id) {
        // Lógica para eliminar un newsletterSubscription
        Optional<NewsletterSubscription> newsletterSubscriptionOptional = newsletterSubscriptionRepository.findById(id);
        if (!newsletterSubscriptionOptional.isPresent()) {
            throw new CustomException("NewsletterSubscription not found with id: " + id);
        }
        // Resto de la lógica para eliminar un newsletterSubscription

        NewsletterSubscription newsletterSubscription = newsletterSubscriptionOptional.get();
        newsletterSubscription.setDeletedAt(Common.builder().build().getCurrentDate());
        newsletterSubscriptionRepository.save(newsletterSubscription);

        return Mono.empty();
    }

}