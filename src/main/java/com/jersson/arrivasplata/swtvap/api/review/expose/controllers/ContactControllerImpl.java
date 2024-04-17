package com.jersson.arrivasplata.swtvap.api.review.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.review.business.service.ContactService;
import com.jersson.arrivasplata.swtvap.api.review.expose.ContactController;
import com.jersson.arrivasplata.swtvap.api.review.mapper.ContactMapper;
import com.jersson.arrivasplata.swtvap.api.review.model.Contact;
import com.jersson.arrivasplata.swtvap.api.review.model.ContactRequest;
import com.jersson.arrivasplata.swtvap.api.review.model.ContactResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/contacts", produces = "application/vnd.swtvap-api-contacts.v1+json")
public class ContactControllerImpl implements ContactController {
    private final ContactService contactService;
    private final ContactMapper contactMapper;

    public ContactControllerImpl(ContactService contactService, ContactMapper contactMapper) {
        this.contactService = contactService;
        this.contactMapper = contactMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ContactResponse> getAllContacts() {
        return Flux.fromIterable(contactService.getAllContacts())
                .map(contact -> {
                    ContactResponse contactResponse = contactMapper.contactToContactResponse(contact);
                    return contactResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ContactResponse> getContactById(@PathVariable Long id) {
        return Mono.just(contactService.getContactById(id))
                .map(contact -> {
                    ContactResponse contactResponse = contactMapper.contactToContactResponse(contact);
                    return contactResponse;
                })
                .defaultIfEmpty(new ContactResponse());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ContactResponse> createContact(@RequestBody ContactRequest contactRequest) {
        Contact contact = contactMapper.contactRequestToContact(contactRequest);

        return Mono.just(contactService.createContact(contact))
                .map(newContact -> {
                    ContactResponse contactResponse = contactMapper.contactToContactResponse(newContact);
                    return contactResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ContactResponse> updateContact(@PathVariable Long id, @RequestBody ContactRequest contactRequest) {
        Contact contact = contactMapper.contactRequestToContact(contactRequest);

        return Mono.just(contactService.updateContact(id, contact))
                .map(updatedContact -> {
                    ContactResponse contactResponse = contactMapper.contactToContactResponse(updatedContact);
                    return contactResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContactById(id);
        return Mono.empty();
    }
}
