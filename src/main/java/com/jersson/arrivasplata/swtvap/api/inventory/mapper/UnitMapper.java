package com.jersson.arrivasplata.swtvap.api.inventory.mapper;

import com.jersson.arrivasplata.swtvap.api.common.model.Unit;
import com.jersson.arrivasplata.swtvap.api.common.model.UnitRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.UnitResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UnitMapper {
    UnitMapper INSTANCE = Mappers.getMapper(UnitMapper.class);

    //@Mapping(target = "id", ignore = true)
    Unit unitRequestToUnit(UnitRequest unitRequest);

    UnitRequest unitToUnitRequest(Unit unit);

    UnitResponse unitToUnitResponse(Unit unit);

    List<UnitResponse> mapUnitsToResponses(List<Unit> units);
}
