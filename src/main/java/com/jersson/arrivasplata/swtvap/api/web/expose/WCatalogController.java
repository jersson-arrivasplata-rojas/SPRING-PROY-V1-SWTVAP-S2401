package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.WCatalogResponse;
import reactor.core.publisher.Flux;

public interface WCatalogController {
    Flux<WCatalogResponse> getAllCatalogs();
    Flux<WCatalogResponse> getAllCatalogByCode(String code);
    // Otros métodos relacionados con catalogo usando Reactor Core
}
