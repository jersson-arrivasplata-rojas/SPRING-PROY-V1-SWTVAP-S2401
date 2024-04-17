package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.WAnalytic;
import com.jersson.arrivasplata.swtvap.api.web.model.WAnalyticRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WAnalyticResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WAnalyticMapper {
    WAnalyticMapper INSTANCE = Mappers.getMapper(WAnalyticMapper.class);

    //@Mapping(target = "id", ignore = true)
    WAnalytic analyticRequestToAnalytic(WAnalyticRequest analyticRequest);

    WAnalyticRequest analyticToAnalyticRequest(WAnalytic analytic);

    WAnalyticResponse analyticToAnalyticResponse(WAnalytic analytic);

    List<WAnalyticResponse> mapAnalyticsToResponses(List<WAnalytic> analytics);
}
