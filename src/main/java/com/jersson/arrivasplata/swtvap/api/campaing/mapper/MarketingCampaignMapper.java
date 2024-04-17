package com.jersson.arrivasplata.swtvap.api.campaing.mapper;

import com.jersson.arrivasplata.swtvap.api.campaing.model.MarketingCampaign;
import com.jersson.arrivasplata.swtvap.api.campaing.model.MarketingCampaignRequest;
import com.jersson.arrivasplata.swtvap.api.campaing.model.MarketingCampaignResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarketingCampaignMapper {
    MarketingCampaignMapper INSTANCE = Mappers.getMapper(MarketingCampaignMapper.class);

    //@Mapping(target = "id", ignore = true)
    MarketingCampaign marketingCampaignRequestToMarketingCampaign(MarketingCampaignRequest marketingCampaignRequest);

    MarketingCampaignRequest marketingCampaignToMarketingCampaignRequest(MarketingCampaign marketingCampaign);

    MarketingCampaignResponse marketingCampaignToMarketingCampaignResponse(MarketingCampaign marketingCampaign);

    List<MarketingCampaignResponse> mapMarketingCampaignsToResponses(List<MarketingCampaign> marketingCampaigns);
}
