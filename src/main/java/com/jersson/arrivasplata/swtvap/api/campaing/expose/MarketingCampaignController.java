package com.jersson.arrivasplata.swtvap.api.campaing.expose;

import com.jersson.arrivasplata.swtvap.api.campaing.model.MarketingCampaignRequest;
import com.jersson.arrivasplata.swtvap.api.campaing.model.MarketingCampaignResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MarketingCampaignController {
    Flux<MarketingCampaignResponse> getAllMarketingCampaigns();
    Mono<MarketingCampaignResponse> getMarketingCampaignById(Long id);
    Mono<MarketingCampaignResponse> createMarketingCampaign(MarketingCampaignRequest marketingCampaignRequest);
    Mono<MarketingCampaignResponse> updateMarketingCampaign(Long id, MarketingCampaignRequest marketingCampaignRequest);
    Mono<Void> deleteMarketingCampaign(Long id);
    // Otros métodos relacionados con marketingCampaigno usando Reactor Core
}
