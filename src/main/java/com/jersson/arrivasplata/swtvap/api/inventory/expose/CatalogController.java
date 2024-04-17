package com.jersson.arrivasplata.swtvap.api.inventory.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.CatalogRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.CatalogResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CatalogController {
    Flux<CatalogResponse> getAllCatalogs();
    Mono<CatalogResponse> getCatalogById(Long id);
    Mono<CatalogResponse> createCatalog(CatalogRequest catalogRequest);
    Mono<CatalogResponse> updateCatalog(Long id, CatalogRequest catalogRequest);
    Mono<Void> deleteCatalog(Long id);
    Mono<ResponseEntity<String>> performUsefulOperationWithResponse();
    // Otros métodos relacionados con catalogo usando Reactor Core
}
