package com.jersson.arrivasplata.swtvap.api.campaing.mapper;

import com.jersson.arrivasplata.swtvap.api.campaing.model.NewsletterSubscription;
import com.jersson.arrivasplata.swtvap.api.campaing.model.NewsletterSubscriptionRequest;
import com.jersson.arrivasplata.swtvap.api.campaing.model.NewsletterSubscriptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewsletterSubscriptionMapper {
    NewsletterSubscriptionMapper INSTANCE = Mappers.getMapper(NewsletterSubscriptionMapper.class);

    //@Mapping(target = "id", ignore = true)
    NewsletterSubscription newsletterSubscriptionRequestToNewsletterSubscription(NewsletterSubscriptionRequest newsletterSubscriptionRequest);

    NewsletterSubscriptionRequest newsletterSubscriptionToNewsletterSubscriptionRequest(NewsletterSubscription newsletterSubscription);

    NewsletterSubscriptionResponse newsletterSubscriptionToNewsletterSubscriptionResponse(NewsletterSubscription newsletterSubscription);

    List<NewsletterSubscriptionResponse> mapNewsletterSubscriptionsToResponses(List<NewsletterSubscription> newsletterSubscriptions);
}
