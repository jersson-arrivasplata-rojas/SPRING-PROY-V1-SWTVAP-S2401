package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WContactService;
import com.jersson.arrivasplata.swtvap.api.web.model.WContact;
import com.jersson.arrivasplata.swtvap.api.web.repository.WContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WContactServiceImpl implements WContactService {
    private final WContactRepository WContactRepository;

    @Autowired
    public WContactServiceImpl(WContactRepository WContactRepository) {
        this.WContactRepository = WContactRepository;
    }

    public WContact createContact(WContact contact) {
        return WContactRepository.save(contact);
    }

}