package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.WNewsletterSubscription;
import com.jersson.arrivasplata.swtvap.api.web.model.WNewsletterSubscriptionRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WNewsletterSubscriptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WNewsletterSubscriptionMapper {
    WNewsletterSubscriptionMapper INSTANCE = Mappers.getMapper(WNewsletterSubscriptionMapper.class);

    //@Mapping(target = "id", ignore = true)
    WNewsletterSubscription newsletterSubscriptionRequestToNewsletterSubscription(WNewsletterSubscriptionRequest newsletterSubscriptionRequest);

    WNewsletterSubscriptionRequest newsletterSubscriptionToNewsletterSubscriptionRequest(WNewsletterSubscription newsletterSubscription);

    WNewsletterSubscriptionResponse newsletterSubscriptionToNewsletterSubscriptionResponse(WNewsletterSubscription newsletterSubscription);

    List<WNewsletterSubscriptionResponse> mapNewsletterSubscriptionsToResponses(List<WNewsletterSubscription> newsletterSubscriptions);
}
