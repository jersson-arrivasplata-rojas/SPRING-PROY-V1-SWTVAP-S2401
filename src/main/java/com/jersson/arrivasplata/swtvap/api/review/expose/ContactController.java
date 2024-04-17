package com.jersson.arrivasplata.swtvap.api.review.expose;

import com.jersson.arrivasplata.swtvap.api.review.model.ContactRequest;
import com.jersson.arrivasplata.swtvap.api.review.model.ContactResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ContactController {
    Flux<ContactResponse> getAllContacts();

    Mono<ContactResponse> getContactById(Long id);

    Mono<ContactResponse> createContact(ContactRequest contact);

    Mono<ContactResponse> updateContact(Long id, ContactRequest updatedContact);

    Mono<Void> deleteContact(Long id);
}
