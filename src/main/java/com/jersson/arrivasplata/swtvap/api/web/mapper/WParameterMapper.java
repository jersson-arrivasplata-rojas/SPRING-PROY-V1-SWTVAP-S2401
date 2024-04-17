package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.WParameter;
import com.jersson.arrivasplata.swtvap.api.web.model.WParameterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WParameterMapper {
    WParameterMapper INSTANCE = Mappers.getMapper(WParameterMapper.class);

    WParameterResponse toParameterResponse(WParameter parameter);

}
