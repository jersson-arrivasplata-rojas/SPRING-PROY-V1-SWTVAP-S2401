package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WContactService;
import com.jersson.arrivasplata.swtvap.api.web.expose.WContactController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.WContactMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.WContact;
import com.jersson.arrivasplata.swtvap.api.web.model.WContactRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WContactResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/w-contacts", produces = "application/vnd.swtvap-api-w-contacts.v1+json")
public class WContactControllerImpl implements WContactController {
    private final WContactService contactService;
    private final WContactMapper contactMapper;

    public WContactControllerImpl(WContactService contactService, WContactMapper contactMapper) {
        this.contactService = contactService;
        this.contactMapper = contactMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<WContactResponse> createContact(@RequestBody WContactRequest contactRequest) {
        WContact contact = contactMapper.contactRequestToContact(contactRequest);

        return Mono.just(contactService.createContact(contact))
                .map(newContact -> {
                    WContactResponse contactResponse = contactMapper.contactToContactResponse(newContact);
                    return contactResponse;
                });
    }

}
