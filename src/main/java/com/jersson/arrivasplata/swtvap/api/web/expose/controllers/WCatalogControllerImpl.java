package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;



import com.jersson.arrivasplata.swtvap.api.web.business.service.WCatalogService;
import com.jersson.arrivasplata.swtvap.api.web.expose.WCatalogController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.WCatalogMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.WCatalogResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/api/w-catalogs", produces = "application/vnd.swtvap-api-w-catalogs.v1+json")
public class WCatalogControllerImpl implements WCatalogController {
    private final WCatalogService catalogService;
    private final WCatalogMapper catalogMapper;


    public WCatalogControllerImpl(WCatalogService catalogService, WCatalogMapper catalogMapper) {
        this.catalogService = catalogService;
        this.catalogMapper = catalogMapper;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Flux<WCatalogResponse> getAllCatalogs() {
        return catalogService.getAllCatalogs()
                .map(catalog -> {
                    WCatalogResponse catalogResponse = catalogMapper.catalogToCatalogResponse(catalog);
                    return catalogResponse;
                });
    }

    @GetMapping(value = "/code/{code}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<WCatalogResponse> getAllCatalogByCode(@PathVariable("code") String code) {
        return catalogService.getAllCatalogByCode(code)
                .map(catalog -> {
                    WCatalogResponse catalogResponse = catalogMapper.catalogToCatalogResponse(catalog);
                    return catalogResponse;
                });
    }

}