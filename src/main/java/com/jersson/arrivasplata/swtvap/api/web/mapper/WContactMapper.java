package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.WContact;
import com.jersson.arrivasplata.swtvap.api.web.model.WContactRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WContactResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WContactMapper {
    WContactMapper INSTANCE = Mappers.getMapper(WContactMapper.class);

    //@Mapping(target = "id", ignore = true)
    WContact contactRequestToContact(WContactRequest contactRequest);

    WContactRequest contactToContactRequest(WContact contact);

    WContactResponse contactToContactResponse(WContact contact);

    List<WContactResponse> mapContactsToResponses(List<WContact> contacts);
}
