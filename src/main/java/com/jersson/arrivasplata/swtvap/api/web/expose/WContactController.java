package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.WContactRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WContactResponse;
import reactor.core.publisher.Mono;

public interface WContactController {
    Mono<WContactResponse> createContact(WContactRequest contact);
}
