package com.jersson.arrivasplata.swtvap.api.review.mapper;

import com.jersson.arrivasplata.swtvap.api.review.model.Contact;
import com.jersson.arrivasplata.swtvap.api.review.model.ContactRequest;
import com.jersson.arrivasplata.swtvap.api.review.model.ContactResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    //@Mapping(target = "id", ignore = true)
    Contact contactRequestToContact(ContactRequest contactRequest);

    ContactRequest contactToContactRequest(Contact contact);

    ContactResponse contactToContactResponse(Contact contact);

    List<ContactResponse> mapContactsToResponses(List<Contact> contacts);
}
