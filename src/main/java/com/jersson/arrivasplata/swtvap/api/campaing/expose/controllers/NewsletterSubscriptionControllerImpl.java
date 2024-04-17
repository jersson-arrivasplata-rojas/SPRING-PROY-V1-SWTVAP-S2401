package com.jersson.arrivasplata.swtvap.api.campaing.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.campaing.business.service.NewsletterSubscriptionService;
import com.jersson.arrivasplata.swtvap.api.campaing.expose.NewsletterSubscriptionController;
import com.jersson.arrivasplata.swtvap.api.campaing.mapper.NewsletterSubscriptionMapper;
import com.jersson.arrivasplata.swtvap.api.campaing.model.NewsletterSubscription;
import com.jersson.arrivasplata.swtvap.api.campaing.model.NewsletterSubscriptionRequest;
import com.jersson.arrivasplata.swtvap.api.campaing.model.NewsletterSubscriptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/newsletter-subscriptions", produces = "application/vnd.swtvap-api-newsletter-subscriptions.v1+json")
public class NewsletterSubscriptionControllerImpl implements NewsletterSubscriptionController {
    private final NewsletterSubscriptionService newsletterSubscriptionService;
    private final NewsletterSubscriptionMapper newsletterSubscriptionMapper;


    public NewsletterSubscriptionControllerImpl(NewsletterSubscriptionService newsletterSubscriptionService, NewsletterSubscriptionMapper newsletterSubscriptionMapper) {
        this.newsletterSubscriptionService = newsletterSubscriptionService;
        this.newsletterSubscriptionMapper = newsletterSubscriptionMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<NewsletterSubscriptionResponse> getAllNewsletterSubscriptions() {
        return newsletterSubscriptionService.getAllNewsletterSubscriptions()
                .map(newsletterSubscription -> {
                    NewsletterSubscriptionResponse newsletterSubscriptionResponse = newsletterSubscriptionMapper.newsletterSubscriptionToNewsletterSubscriptionResponse(newsletterSubscription);
                    return newsletterSubscriptionResponse;
                });
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<NewsletterSubscriptionResponse> getNewsletterSubscriptionById(@PathVariable Long id) {
        return newsletterSubscriptionService.getNewsletterSubscriptionById(id)
                .map(newsletterSubscription -> {
                    NewsletterSubscriptionResponse newsletterSubscriptionResponse = newsletterSubscriptionMapper.newsletterSubscriptionToNewsletterSubscriptionResponse(newsletterSubscription);
                    return newsletterSubscriptionResponse;

                });
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<NewsletterSubscriptionResponse> createNewsletterSubscription(@RequestBody NewsletterSubscriptionRequest newsletterSubscriptionRequest) {
        NewsletterSubscription newsletterSubscription = newsletterSubscriptionMapper.newsletterSubscriptionRequestToNewsletterSubscription(newsletterSubscriptionRequest);

        return newsletterSubscriptionService.createNewsletterSubscription(newsletterSubscription)
                .map(newNewsletterSubscription -> {
                    NewsletterSubscriptionResponse newsletterSubscriptionResponse = newsletterSubscriptionMapper.newsletterSubscriptionToNewsletterSubscriptionResponse(newNewsletterSubscription);
                    return newsletterSubscriptionResponse;
                });
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<NewsletterSubscriptionResponse> updateNewsletterSubscription(@PathVariable Long id, @RequestBody NewsletterSubscriptionRequest newsletterSubscriptionRequest) {
        NewsletterSubscription newsletterSubscription = newsletterSubscriptionMapper.newsletterSubscriptionRequestToNewsletterSubscription(newsletterSubscriptionRequest);
        newsletterSubscription.setNewsletterSubscriptionId(id);
        return newsletterSubscriptionService.updateNewsletterSubscription(newsletterSubscription)
                .map(updatedNewsletterSubscription -> {
                    NewsletterSubscriptionResponse newsletterSubscriptionResponse = newsletterSubscriptionMapper.newsletterSubscriptionToNewsletterSubscriptionResponse(updatedNewsletterSubscription);
                    return newsletterSubscriptionResponse;
                });
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteNewsletterSubscription(@PathVariable Long id) {
        return newsletterSubscriptionService.deleteNewsletterSubscriptionById(id);
    }

    // Implementa otros métodos del controlador si es necesario
}