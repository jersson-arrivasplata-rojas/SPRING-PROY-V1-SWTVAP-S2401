package com.jersson.arrivasplata.swtvap.api.order.mapper;

import com.jersson.arrivasplata.swtvap.api.common.model.OrderDetail;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderDetailRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);
    @Mapping(source = "orderDetailId", target = "orderDetailId")
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "unitPriceUSD", target = "unitPriceUSD")
    @Mapping(source = "unitPriceEUR", target = "unitPriceEUR")
    @Mapping(source = "subtotal", target = "subtotal")
    @Mapping(source = "subtotalUSD", target = "subtotalUSD")
    @Mapping(source = "subtotalEUR", target = "subtotalEUR")
    @Mapping(source = "discountPercentage", target = "discountPercentage")
    @Mapping(source = "otherDetails", target = "otherDetails")
    @Mapping(source = "status", target = "status")
    OrderDetail orderDetailRequestToOrderDetail(OrderDetailRequest orderDetailRequest);

    OrderDetailRequest orderDetailToOrderDetailRequest(OrderDetail orderDetail);

    @Mapping(source = "orderDetailId", target = "orderDetailId")
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "unitPrice", target = "unitPrice")
    @Mapping(source = "unitPriceUSD", target = "unitPriceUSD")
    @Mapping(source = "unitPriceEUR", target = "unitPriceEUR")
    @Mapping(source = "subtotal", target = "subtotal")
    @Mapping(source = "subtotalUSD", target = "subtotalUSD")
    @Mapping(source = "subtotalEUR", target = "subtotalEUR")
    @Mapping(source = "discountPercentage", target = "discountPercentage")
    @Mapping(source = "otherDetails", target = "otherDetails")
    @Mapping(source = "status", target = "status")
    OrderDetailResponse orderDetailToOrderDetailResponse(OrderDetail orderDetail);

    List<OrderDetailResponse> mapOrderDetailsToResponses(List<OrderDetail> orderDetails);


}
