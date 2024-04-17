package com.jersson.arrivasplata.swtvap.api.campaing.repository;

import com.jersson.arrivasplata.swtvap.api.campaing.model.MarketingCampaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketingCampaignRepository extends JpaRepository<MarketingCampaign, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
    MarketingCampaign findByName(String name);
}

