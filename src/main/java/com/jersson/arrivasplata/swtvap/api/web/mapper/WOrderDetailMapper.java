package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.WOrderDetail;
import com.jersson.arrivasplata.swtvap.api.web.model.WOrderDetailRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WOrderDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface WOrderDetailMapper {
    WOrderDetailMapper INSTANCE = Mappers.getMapper(WOrderDetailMapper.class);
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
    WOrderDetail orderDetailRequestToOrderDetail(WOrderDetailRequest orderDetailRequest);

    WOrderDetailRequest orderDetailToOrderDetailRequest(WOrderDetail orderDetail);

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
    WOrderDetailResponse orderDetailToOrderDetailResponse(WOrderDetail orderDetail);

    List<WOrderDetailResponse> mapOrderDetailsToResponses(List<WOrderDetail> orderDetails);


}
