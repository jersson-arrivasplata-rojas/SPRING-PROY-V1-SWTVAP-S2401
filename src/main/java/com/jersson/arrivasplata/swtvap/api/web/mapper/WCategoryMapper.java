package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.WCategory;
import com.jersson.arrivasplata.swtvap.api.web.model.WCategoryRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WCategoryMapper {
    WCategoryMapper INSTANCE = Mappers.getMapper(WCategoryMapper.class);

    //@Mapping(target = "id", ignore = true)
    WCategory categoryRequestToCategory(WCategoryRequest categoryRequest);

    WCategoryRequest categoryToCategoryRequest(WCategory category);

    @Mapping(target = "products", expression = "java(new ArrayList<>(category.getProducts()))")
    WCategoryResponse categoryToCategoryResponse(WCategory category);

    List<WCategoryResponse> mapCategoriesToResponses(List<WCategory> categories);
}
