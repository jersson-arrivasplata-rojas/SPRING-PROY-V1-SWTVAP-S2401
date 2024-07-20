package com.jersson.arrivasplata.swtvap.api.product.mapper;

import com.jersson.arrivasplata.swtvap.api.common.model.Product;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    //@Mapping(target = "id", ignore = true)

    @Mapping(target = "otherDetailsEn")
    @Mapping(target = "descriptionEn")
    @Mapping(target = "nameEn")
    @Mapping(target = "path")
    Product productRequestToProduct(ProductRequest productRequest);

    ProductRequest productToProductRequest(Product product);
    @Mapping(target = "otherDetailsEn")
    @Mapping(target = "descriptionEn")
    @Mapping(target = "nameEn")
    @Mapping(target = "path")
    ProductResponse productToProductResponse(Product product);

    List<ProductResponse> mapProductsToResponses(List<Product> products);
}
