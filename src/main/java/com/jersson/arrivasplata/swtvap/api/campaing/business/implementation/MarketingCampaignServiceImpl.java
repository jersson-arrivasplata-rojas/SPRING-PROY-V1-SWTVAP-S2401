package com.jersson.arrivasplata.swtvap.api.campaing.business.implementation;

import com.jersson.arrivasplata.swtvap.api.campaing.business.service.MarketingCampaignService;
import com.jersson.arrivasplata.swtvap.api.campaing.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.campaing.model.MarketingCampaign;
import com.jersson.arrivasplata.swtvap.api.campaing.repository.MarketingCampaignRepository;
import com.jersson.arrivasplata.swtvap.api.campaing.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class MarketingCampaignServiceImpl implements MarketingCampaignService {

    private final MarketingCampaignRepository marketingCampaignRepository;

    @Autowired
    public MarketingCampaignServiceImpl(MarketingCampaignRepository marketingCampaignRepository) {
        this.marketingCampaignRepository = marketingCampaignRepository;
    }

    @Override
    public Flux<MarketingCampaign> getAllMarketingCampaigns() {
        return Flux.fromIterable(marketingCampaignRepository.findAll());
    }

    public Mono<MarketingCampaign> getMarketingCampaignById(Long id) {
        return Mono.just(marketingCampaignRepository.findById(id)
                .orElseThrow(() -> new CustomException("MarketingCampaign not found with id: " + id)));
    }

    public Mono<MarketingCampaign> createMarketingCampaign(MarketingCampaign marketingCampaign) {
        // Lógica para crear un nuevo marketingCampaign
        return Mono.just(marketingCampaignRepository.save(marketingCampaign));
    }

    public Mono<MarketingCampaign> updateMarketingCampaign(MarketingCampaign marketingCampaign) {
        // Lógica para actualizar un marketingCampaign
        if (marketingCampaign.getMarketingCampaignId() == null) {
            throw new CustomException("MarketingCampaign id is required.");
        }
        // Resto de la lógica para actualizar un marketingCampaign
        return Mono.just(marketingCampaignRepository.save(marketingCampaign));
    }

    public Mono<Void> deleteMarketingCampaignById(Long id) {
        // Lógica para eliminar un marketingCampaign
        Optional<MarketingCampaign> marketingCampaignOptional = marketingCampaignRepository.findById(id);
        if (!marketingCampaignOptional.isPresent()) {
            throw new CustomException("MarketingCampaign not found with id: " + id);
        }
        // Resto de la lógica para eliminar un marketingCampaign
        MarketingCampaign marketingCampaign = marketingCampaignOptional.get();
        marketingCampaign.setDeletedAt(Common.builder().build().getCurrentDate());
        marketingCampaignRepository.save(marketingCampaign);

        return Mono.empty();
    }

    public MarketingCampaign getMarketingCampaignByName(String name) {
        // Implementación para recuperar el marketingCampaign por nombre desde el repositorio
        return marketingCampaignRepository.findByName(name);
    }
}