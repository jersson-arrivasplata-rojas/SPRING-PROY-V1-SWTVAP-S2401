package com.jersson.arrivasplata.swtvap.api.inventory.mapper;

import com.jersson.arrivasplata.swtvap.api.common.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.common.model.CatalogRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.CatalogResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatalogMapper {
    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    @Mapping(target = "descriptionEn")
    @Mapping(target = "nameEn")
    Catalog catalogRequestToCatalog(CatalogRequest catalogRequest);

    CatalogRequest catalogToCatalogRequest(Catalog catalog);

    CatalogResponse catalogToCatalogResponse(Catalog catalog);

    List<CatalogResponse> mapCatalogsToResponses(List<Catalog> catalogs);
}
