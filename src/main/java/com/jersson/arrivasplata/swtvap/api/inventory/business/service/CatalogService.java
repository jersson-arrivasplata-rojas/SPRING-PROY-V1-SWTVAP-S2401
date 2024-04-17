package com.jersson.arrivasplata.swtvap.api.inventory.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.Catalog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CatalogService {
    Flux<Catalog> getAllCatalogs();
    Mono<Catalog> getCatalogById(Long id);
    Mono<Catalog> createCatalog(Catalog catalog);
    Mono<Catalog> updateCatalog(Catalog catalog);
    Mono<Void> deleteCatalogById(Long id);
    // Otros métodos relacionados con catalogo usando Reactor Core
}
