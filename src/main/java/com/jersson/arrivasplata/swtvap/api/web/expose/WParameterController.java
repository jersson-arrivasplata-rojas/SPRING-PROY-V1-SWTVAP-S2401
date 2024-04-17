package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.WParameterResponse;
import reactor.core.publisher.Flux;

public interface WParameterController {

    Flux<WParameterResponse> getStructureByCode(String code);
}
