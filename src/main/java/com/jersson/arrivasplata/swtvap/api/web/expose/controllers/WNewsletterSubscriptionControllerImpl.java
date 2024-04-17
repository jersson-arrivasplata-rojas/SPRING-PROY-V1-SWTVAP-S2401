package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WNewsletterSubscriptionService;
import com.jersson.arrivasplata.swtvap.api.web.expose.WNewsletterSubscriptionController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.WNewsletterSubscriptionMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.WNewsletterSubscription;
import com.jersson.arrivasplata.swtvap.api.web.model.WNewsletterSubscriptionRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WNewsletterSubscriptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/w-newsletter-subscriptions", produces = "application/vnd.swtvap-api-w-newsletter-subscriptions.v1+json")
public class WNewsletterSubscriptionControllerImpl implements WNewsletterSubscriptionController {
    private final WNewsletterSubscriptionService newsletterSubscriptionService;
    private final WNewsletterSubscriptionMapper newsletterSubscriptionMapper;


    public WNewsletterSubscriptionControllerImpl(WNewsletterSubscriptionService newsletterSubscriptionService, WNewsletterSubscriptionMapper newsletterSubscriptionMapper) {
        this.newsletterSubscriptionService = newsletterSubscriptionService;
        this.newsletterSubscriptionMapper = newsletterSubscriptionMapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<WNewsletterSubscriptionResponse> createNewsletterSubscription(@RequestBody WNewsletterSubscriptionRequest newsletterSubscriptionRequest) {
        WNewsletterSubscription newsletterSubscription = newsletterSubscriptionMapper.newsletterSubscriptionRequestToNewsletterSubscription(newsletterSubscriptionRequest);

        return newsletterSubscriptionService.createNewsletterSubscription(newsletterSubscription)
                .map(newNewsletterSubscription -> {
                    WNewsletterSubscriptionResponse newsletterSubscriptionResponse = newsletterSubscriptionMapper.newsletterSubscriptionToNewsletterSubscriptionResponse(newNewsletterSubscription);
                    return newsletterSubscriptionResponse;
                });
    }


    // Implementa otros métodos del controlador si es necesario
}