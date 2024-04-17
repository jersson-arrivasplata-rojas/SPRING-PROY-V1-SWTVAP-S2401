package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.WOrder;
import com.jersson.arrivasplata.swtvap.api.web.model.WOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WOrderMapper {
    WOrderMapper INSTANCE = Mappers.getMapper(WOrderMapper.class);

    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "clientId", target = "clientId")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "orderDate", target = "orderDate")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "subtotal", target = "subtotal")
    @Mapping(source = "subtotalUSD", target = "subtotalUSD")
    @Mapping(source = "subtotalEUR", target = "subtotalEUR")
    @Mapping(source = "taxes", target = "taxes")
    @Mapping(source = "taxesUSD", target = "taxesUSD")
    @Mapping(source = "taxesEUR", target = "taxesEUR")
    @Mapping(source = "discountAmount", target = "discountAmount")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "totalUSD", target = "totalUSD")
    @Mapping(source = "totalEUR", target = "totalEUR")
    @Mapping(source = "pickUp", target = "pickUp")
    @Mapping(source = "otherDetails", target = "otherDetails")
    WOrderResponse orderToOrderResponse(WOrder order);

}
