package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.WCatalog;
import com.jersson.arrivasplata.swtvap.api.web.model.WCatalogRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WCatalogResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WCatalogMapper {
    WCatalogMapper INSTANCE = Mappers.getMapper(WCatalogMapper.class);

    //@Mapping(target = "id", ignore = true)
    WCatalog catalogRequestToCatalog(WCatalogRequest catalogRequest);

    WCatalogRequest catalogToCatalogRequest(WCatalog catalog);

    @Mapping(target = "categories", expression = "java(new ArrayList<>(catalog.getCategories()))")
    WCatalogResponse catalogToCatalogResponse(WCatalog catalog);

    List<WCatalogResponse> mapCatalogsToResponses(List<WCatalog> catalogs);
}
