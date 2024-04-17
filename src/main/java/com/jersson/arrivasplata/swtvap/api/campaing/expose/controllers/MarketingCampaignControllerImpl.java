package com.jersson.arrivasplata.swtvap.api.campaing.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.campaing.business.service.MarketingCampaignService;
import com.jersson.arrivasplata.swtvap.api.campaing.expose.MarketingCampaignController;
import com.jersson.arrivasplata.swtvap.api.campaing.mapper.MarketingCampaignMapper;
import com.jersson.arrivasplata.swtvap.api.campaing.model.MarketingCampaign;
import com.jersson.arrivasplata.swtvap.api.campaing.model.MarketingCampaignRequest;
import com.jersson.arrivasplata.swtvap.api.campaing.model.MarketingCampaignResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/marketing-campaigns", produces = "application/vnd.swtvap-api-marketing-campaigns.v1+json")
public class MarketingCampaignControllerImpl implements MarketingCampaignController {
    private final MarketingCampaignService marketingCampaignService;
    private final MarketingCampaignMapper marketingCampaignMapper;

    public MarketingCampaignControllerImpl(MarketingCampaignService marketingCampaignService, MarketingCampaignMapper marketingCampaignMapper) {
        this.marketingCampaignService = marketingCampaignService;
        this.marketingCampaignMapper = marketingCampaignMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<MarketingCampaignResponse> getAllMarketingCampaigns() {
        return marketingCampaignService.getAllMarketingCampaigns()
                .map(marketingCampaign -> {
                    MarketingCampaignResponse marketingCampaignResponse = marketingCampaignMapper.marketingCampaignToMarketingCampaignResponse(marketingCampaign);
                    return marketingCampaignResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<MarketingCampaignResponse> getMarketingCampaignById(@PathVariable Long id) {
        return marketingCampaignService.getMarketingCampaignById(id)
                .map(marketingCampaign -> {
                    MarketingCampaignResponse marketingCampaignResponse = marketingCampaignMapper.marketingCampaignToMarketingCampaignResponse(marketingCampaign);
                    return marketingCampaignResponse;

                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MarketingCampaignResponse> createMarketingCampaign(@RequestBody MarketingCampaignRequest marketingCampaignRequest) {
        MarketingCampaign marketingCampaign = marketingCampaignMapper.marketingCampaignRequestToMarketingCampaign(marketingCampaignRequest);

        return marketingCampaignService.createMarketingCampaign(marketingCampaign)
                .map(newMarketingCampaign -> {
                    MarketingCampaignResponse marketingCampaignResponse = marketingCampaignMapper.marketingCampaignToMarketingCampaignResponse(newMarketingCampaign);
                    return marketingCampaignResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<MarketingCampaignResponse> updateMarketingCampaign(@PathVariable Long id, @RequestBody MarketingCampaignRequest marketingCampaignRequest) {
        MarketingCampaign marketingCampaign = marketingCampaignMapper.marketingCampaignRequestToMarketingCampaign(marketingCampaignRequest);
        marketingCampaign.setMarketingCampaignId(id);
        return marketingCampaignService.updateMarketingCampaign(marketingCampaign)
                .map(updatedMarketingCampaign -> {
                    MarketingCampaignResponse marketingCampaignResponse = marketingCampaignMapper.marketingCampaignToMarketingCampaignResponse(updatedMarketingCampaign);
                    return marketingCampaignResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMarketingCampaign(@PathVariable Long id) {
        return marketingCampaignService.deleteMarketingCampaignById(id);
    }

    // Implementa otros métodos del controlador si es necesario
}