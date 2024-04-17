package com.jersson.arrivasplata.swtvap.api.setting.mapper;

import com.jersson.arrivasplata.swtvap.api.setting.model.Parameter;
import com.jersson.arrivasplata.swtvap.api.setting.model.ParameterRequest;
import com.jersson.arrivasplata.swtvap.api.setting.model.ParameterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParameterMapper {
    ParameterMapper INSTANCE = Mappers.getMapper(ParameterMapper.class);

    //@Mapping(target = "id", ignore = true)
    @Mapping(source = "code", target = "code")
    Parameter parameterRequestToParameter(ParameterRequest parameterRequest);

    ParameterRequest parameterToParameterRequest(Parameter parameter);

    @Mapping(source = "code", target = "code")
    ParameterResponse parameterToParameterResponse(Parameter parameter);

    List<ParameterResponse> mapParametersToResponses(List<Parameter> parameters);
}
