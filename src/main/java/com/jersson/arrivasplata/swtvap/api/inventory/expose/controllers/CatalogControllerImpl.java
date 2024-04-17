package com.jersson.arrivasplata.swtvap.api.inventory.expose.controllers;


import com.jersson.arrivasplata.swtvap.api.common.util.UtilityService;
import com.jersson.arrivasplata.swtvap.api.inventory.business.service.CatalogService;
import com.jersson.arrivasplata.swtvap.api.inventory.expose.CatalogController;
import com.jersson.arrivasplata.swtvap.api.inventory.mapper.CatalogMapper;
import com.jersson.arrivasplata.swtvap.api.common.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.common.model.CatalogRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.CatalogResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/catalogs", produces = "application/vnd.swtvap-api-inventory.v1+json")
public class CatalogControllerImpl implements CatalogController {
    private final CatalogService catalogService;
    private final UtilityService utilityService;
    private final CatalogMapper catalogMapper;


    public CatalogControllerImpl(CatalogService catalogService, CatalogMapper catalogMapper, UtilityService utilityService) {
        this.catalogService = catalogService;
        this.catalogMapper = catalogMapper;
        this.utilityService = utilityService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<CatalogResponse> getAllCatalogs() {
        return catalogService.getAllCatalogs()
                .map(catalog -> {
                    CatalogResponse catalogResponse = catalogMapper.catalogToCatalogResponse(catalog);
                    return catalogResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CatalogResponse> getCatalogById(@PathVariable Long id) {
        return catalogService.getCatalogById(id)
                .map(catalog -> {
                    CatalogResponse catalogResponse = catalogMapper.catalogToCatalogResponse(catalog);
                    return catalogResponse;

                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CatalogResponse> createCatalog(@RequestBody CatalogRequest catalogRequest) {
        Catalog catalog = catalogMapper.catalogRequestToCatalog(catalogRequest);

        return catalogService.createCatalog(catalog)
                .map(newCatalog -> {
                    CatalogResponse catalogResponse = catalogMapper.catalogToCatalogResponse(newCatalog);
                    return catalogResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CatalogResponse> updateCatalog(@PathVariable Long id, @RequestBody CatalogRequest catalogRequest) {
        Catalog catalog = catalogMapper.catalogRequestToCatalog(catalogRequest);
        catalog.setCatalogId(id);
        return catalogService.updateCatalog(catalog)
                .map(updatedCatalog -> {
                    CatalogResponse catalogResponse = catalogMapper.catalogToCatalogResponse(updatedCatalog);
                    return catalogResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCatalog(@PathVariable Long id) {
        return catalogService.deleteCatalogById(id);
    }

    @GetMapping("/doSomething")
    public Mono<ResponseEntity<String>> performUsefulOperationWithResponse() {
        utilityService.doSomething();
        return Mono.just(ResponseEntity.ok("Operación útil realizada de manera reactiva"));
    }

    // Implementa otros métodos del controlador si es necesario
}