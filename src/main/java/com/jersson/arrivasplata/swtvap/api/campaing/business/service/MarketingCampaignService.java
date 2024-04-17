package com.jersson.arrivasplata.swtvap.api.campaing.business.service;

import com.jersson.arrivasplata.swtvap.api.campaing.model.MarketingCampaign;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MarketingCampaignService {
    Flux<MarketingCampaign> getAllMarketingCampaigns();
    Mono<MarketingCampaign> getMarketingCampaignById(Long id);
    Mono<MarketingCampaign> createMarketingCampaign(MarketingCampaign marketingCampaign);
    Mono<MarketingCampaign> updateMarketingCampaign(MarketingCampaign marketingCampaign);
    Mono<Void> deleteMarketingCampaignById(Long id);
    // Otros métodos relacionados con producto usando Reactor Core
}
