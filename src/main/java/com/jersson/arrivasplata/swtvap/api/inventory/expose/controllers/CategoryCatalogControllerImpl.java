package com.jersson.arrivasplata.swtvap.api.inventory.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.inventory.business.service.CategoryCatalogService;
import com.jersson.arrivasplata.swtvap.api.inventory.expose.CategoryCatalogController;
import com.jersson.arrivasplata.swtvap.api.common.model.CategoryCatalog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/category-catalogs", produces = "application/vnd.swtvap-api-category-catalogs.v1+json")
public class CategoryCatalogControllerImpl implements CategoryCatalogController {
    private final CategoryCatalogService categoryCatalogService;

    public CategoryCatalogControllerImpl(CategoryCatalogService categoryCatalogService) {
        this.categoryCatalogService = categoryCatalogService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<CategoryCatalog> getAllCategoryCatalogs() {
        return categoryCatalogService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CategoryCatalog> getCategoryCatalogById(@PathVariable Long id) {
        return categoryCatalogService.findById(id)
                .map(categoryCatalog -> categoryCatalog);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CategoryCatalog> createCategoryCatalog(@RequestBody CategoryCatalog categoryCatalog) {
        return categoryCatalogService.save(categoryCatalog)
                .map(newCategoryCatalog -> newCategoryCatalog);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CategoryCatalog> updateCategoryCatalog(@PathVariable Long id, @RequestBody CategoryCatalog updatedCategoryCatalog) {
        return categoryCatalogService.findById(id)
                .flatMap(existingCategoryCatalog -> {
                    updatedCategoryCatalog.setId(id);
                    return categoryCatalogService.save(updatedCategoryCatalog);
                })
                .map(updated -> updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCategoryCatalog(@PathVariable Long id) {
        return categoryCatalogService.findById(id)
                .flatMap(existingCategoryCatalog -> {
                    categoryCatalogService.deleteById(id);
                    return Mono.empty();
                });
    }
/*
    @GetMapping("/categories/{categoryId}/catalogs")
    public Flux<Catalog> getCatalogsByCategory(@PathVariable Long categoryId) {
        return categoryCatalogService.findByCategoryName(categoryId);
    }

    @GetMapping("/catalogs/{catalogId}/categories")
    public Flux<Category> getCategoriesByCatalog(@PathVariable Long catalogId) {
        return categoryCatalogService.getCategoriesByCatalog(catalogId);
    }*/
}
