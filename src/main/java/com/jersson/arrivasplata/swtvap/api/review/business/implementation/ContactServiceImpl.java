package com.jersson.arrivasplata.swtvap.api.review.business.implementation;

import com.jersson.arrivasplata.swtvap.api.review.business.service.ContactService;
import com.jersson.arrivasplata.swtvap.api.review.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.review.model.Contact;
import com.jersson.arrivasplata.swtvap.api.review.repository.ContactRepository;
import com.jersson.arrivasplata.swtvap.api.review.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact updatedContact) {
        updatedContact.setContactId(id);
        return contactRepository.save(updatedContact);
    }

    public void deleteContactById(Long id) {
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if (!contactOptional.isPresent()) {
            throw new CustomException("Review not found with id: " + id);
        }
        // Resto de la lógica para eliminar un contact
        Contact review = contactOptional.get();
        review.setDeletedAt(Common.builder().build().getCurrentDate());
        contactRepository.save(review);
    }
}