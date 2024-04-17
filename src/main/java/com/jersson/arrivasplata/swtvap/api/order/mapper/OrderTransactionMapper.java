package com.jersson.arrivasplata.swtvap.api.order.mapper;

import com.jersson.arrivasplata.swtvap.api.common.model.OrderTransaction;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderTransactionRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderTransactionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")

public interface OrderTransactionMapper {
    @Mapping(source = "orderTransactionId", target = "orderTransactionId")
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "paymentMethod", target = "paymentMethod")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "typeCurrency", target = "typeCurrency")
    @Mapping(source = "transactionDate", target = "transactionDate")
    OrderTransaction orderTransactionRequestToOrderTransaction(OrderTransactionRequest orderTransactionRequest);

    OrderTransactionRequest orderTransactionToOrderTransactionRequest(OrderTransaction orderTransaction);

    @Mapping(source = "orderTransactionId", target = "orderTransactionId")
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "paymentMethod", target = "paymentMethod")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "typeCurrency", target = "typeCurrency")
    @Mapping(source = "transactionDate", target = "transactionDate")
    OrderTransactionResponse orderTransactionToOrderTransactionResponse(OrderTransaction orderTransaction);

    List<OrderTransactionResponse> mapOrderTransactionToResponses(List<OrderTransaction> orderTransaction);
}
