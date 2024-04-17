package com.jersson.arrivasplata.swtvap.api.logistic.mapper;

import com.jersson.arrivasplata.swtvap.api.logistic.model.Dispatches;
import com.jersson.arrivasplata.swtvap.api.logistic.model.DispatchesRequest;
import com.jersson.arrivasplata.swtvap.api.logistic.model.DispatchesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface DispatchesMapper {
    DispatchesMapper INSTANCE = Mappers.getMapper(DispatchesMapper.class);
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "providerId", target = "providerId")
    @Mapping(source = "cost", target = "cost")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "otherDetails", target = "otherDetails")
    Dispatches dispatchesRequestToDispatches(DispatchesRequest dispatchesRequest);

    DispatchesRequest dispatchesToDispatchesRequest(Dispatches dispatches);
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "providerId", target = "providerId")
    @Mapping(source = "cost", target = "cost")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "otherDetails", target = "otherDetails")
    DispatchesResponse dispatchesToDispatchesResponse(Dispatches dispatches);

    List<DispatchesResponse> mapDispatchesToResponses(List<Dispatches> dispatches);
}
