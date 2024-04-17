package com.jersson.arrivasplata.swtvap.api.inventory.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.CategoryCatalog;
import reactor.core.publisher.Mono;

public interface CategoryCatalogController {
    Mono<CategoryCatalog> getCategoryCatalogById(Long id);

    Mono<CategoryCatalog> createCategoryCatalog(CategoryCatalog categoryCatalog);

    Mono<CategoryCatalog> updateCategoryCatalog(Long id, CategoryCatalog updatedCategoryCatalog);

    Mono<Void> deleteCategoryCatalog(Long id);

    /*Flux<Catalog> getCatalogsByCategory(Long categoryId);

    Flux<Category> getCategoriesByCatalog(Long catalogId);*/
}
