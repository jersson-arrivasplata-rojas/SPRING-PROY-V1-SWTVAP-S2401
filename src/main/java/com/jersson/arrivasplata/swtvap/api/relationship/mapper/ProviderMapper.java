package com.jersson.arrivasplata.swtvap.api.relationship.mapper;
import com.jersson.arrivasplata.swtvap.api.common.model.Provider;
import com.jersson.arrivasplata.swtvap.api.common.model.ProviderRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.ProviderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProviderMapper {
    ProviderMapper INSTANCE = Mappers.getMapper(ProviderMapper.class);
   // @Mapping(target = "id", ignore = true)
   @Mapping(source = "providerId", target = "providerId")
   @Mapping(source = "name", target = "name")
   @Mapping(source = "address", target = "address")
   @Mapping(source = "phone", target = "phone")
   @Mapping(source = "cellphone", target = "cellphone")
   @Mapping(source = "countryCode", target = "countryCode")
   @Mapping(source = "email", target = "email")
   @Mapping(source = "whatsapp", target = "whatsapp")
   @Mapping(source = "details", target = "details")
   @Mapping(source = "otherDetails", target = "otherDetails")
   @Mapping(source = "status", target = "status")
    Provider providerRequestToProvider(ProviderRequest providerRequest);
    ProviderRequest providerToProviderRequest(Provider provider);
    @Mapping(source = "providerId", target = "providerId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "cellphone", target = "cellphone")
    @Mapping(source = "countryCode", target = "countryCode")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "whatsapp", target = "whatsapp")
    @Mapping(source = "details", target = "details")
    @Mapping(source = "otherDetails", target = "otherDetails")
    @Mapping(source = "status", target = "status")
    ProviderResponse providerToProviderResponse(Provider provider);
    List<ProviderResponse> mapProvidersToResponses(List<Provider> providers);
}
