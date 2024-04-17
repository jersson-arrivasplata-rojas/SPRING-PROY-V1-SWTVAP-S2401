package com.jersson.arrivasplata.swtvap.api.web.business.service;

import com.jersson.arrivasplata.swtvap.api.web.model.WCatalog;
import reactor.core.publisher.Flux;

public interface WCatalogService {
    Flux<WCatalog> getAllCatalogs();
    Flux<WCatalog> getAllCatalogByCode(String code);
}
