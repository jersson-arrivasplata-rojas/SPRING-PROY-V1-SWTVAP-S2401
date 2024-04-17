package com.jersson.arrivasplata.swtvap.api.order.mapper;

import com.jersson.arrivasplata.swtvap.api.common.model.OrderAmount;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderAmountRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderAmountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface OrderAmountMapper {
    OrderAmountMapper INSTANCE = Mappers.getMapper(OrderAmountMapper.class);

    @Mapping(source = "orderAmountId", target = "orderAmountId")
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "amountUSD", target = "amountUSD")
    @Mapping(source = "amountEUR", target = "amountEUR")
    @Mapping(source = "otherDetails", target = "otherDetails")
    OrderAmount orderAmountRequestToOrderAmount(OrderAmountRequest orderAmountRequest);
    OrderAmountRequest orderAmountToOrderAmountRequest(OrderAmount orderAmount);
    @Mapping(source = "orderAmountId", target = "orderAmountId")
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "amountUSD", target = "amountUSD")
    @Mapping(source = "amountEUR", target = "amountEUR")
    @Mapping(source = "otherDetails", target = "otherDetails")
    OrderAmountResponse orderAmountToOrderAmountResponse(OrderAmount orderAmount);

    List<OrderAmountResponse> mapOrderAmountsToResponses(List<OrderAmount> orderAmounts);

}
