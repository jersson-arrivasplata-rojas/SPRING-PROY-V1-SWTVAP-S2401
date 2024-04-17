package com.jersson.arrivasplata.swtvap.api.order.mapper;

import com.jersson.arrivasplata.swtvap.api.common.model.Order;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

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
    Order orderRequestToOrder(OrderRequest orderRequest);

    OrderRequest orderToOrderRequest(Order order);

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
    OrderResponse orderToOrderResponse(Order order);

    List<OrderResponse> mapOrdersToResponses(List<Order> orders);

}
