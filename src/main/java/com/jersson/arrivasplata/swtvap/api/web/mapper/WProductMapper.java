package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.WProduct;
import com.jersson.arrivasplata.swtvap.api.web.model.WProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WProductMapper {
    WProductMapper INSTANCE = Mappers.getMapper(WProductMapper.class);

    @Mapping(target = "deletedAt", ignore = true)
    WProductResponse toProductResponse(WProduct product);

    //@Mapping(target = "productImages", expression = "java(new ArrayList<>(product.getProductImages()))")
    @Mapping(target = "comments", expression = "java(new ArrayList<>(product.getProductComments()))")
    @Mapping(target = "parameters", expression = "java(new ArrayList<>(product.getParameters()))")
    @Mapping(target = "discounts", expression = "java(new ArrayList<>(product.getProductDiscounts()))")
    @Mapping(target = "images", expression = "java(new ArrayList<>(product.getProductImages()))")
    @Mapping(target = "units", expression = "java(new ArrayList<>(product.getUnits()))")
    @Mapping(target = "deletedAt", ignore = true)
    WProductResponse productToProductResponse(WProduct product);
}
