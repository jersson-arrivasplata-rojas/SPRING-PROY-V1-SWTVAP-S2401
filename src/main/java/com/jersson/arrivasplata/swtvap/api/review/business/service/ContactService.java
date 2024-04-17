package com.jersson.arrivasplata.swtvap.api.review.business.service;

import com.jersson.arrivasplata.swtvap.api.review.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();

    Contact getContactById(Long id);

    Contact createContact(Contact review);

    Contact updateContact(Long id, Contact updatedContact);

    void deleteContactById(Long id);
}
