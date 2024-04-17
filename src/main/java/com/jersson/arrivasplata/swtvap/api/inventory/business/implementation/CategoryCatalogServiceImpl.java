package com.jersson.arrivasplata.swtvap.api.inventory.business.implementation;

import com.jersson.arrivasplata.swtvap.api.inventory.business.service.CategoryCatalogService;
import com.jersson.arrivasplata.swtvap.api.common.model.CategoryCatalog;
import com.jersson.arrivasplata.swtvap.api.inventory.repository.CategoryCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryCatalogServiceImpl implements CategoryCatalogService {
    private final CategoryCatalogRepository categoryCatalogRepository;

    @Autowired
    public CategoryCatalogServiceImpl(CategoryCatalogRepository categoryCatalogRepository) {
        this.categoryCatalogRepository = categoryCatalogRepository;
    }


    public Flux<CategoryCatalog> findAll() {
        return Flux.fromIterable(categoryCatalogRepository.findAll());
    }

    public Mono<CategoryCatalog> findById(Long id) {
        return Mono.justOrEmpty(categoryCatalogRepository.findById(id));
    }

    public Mono<CategoryCatalog> save(CategoryCatalog categoryCatalog) {
        return Mono.justOrEmpty(categoryCatalogRepository.save(categoryCatalog));
    }

    public Mono<Void> deleteById(Long id) {
        categoryCatalogRepository.deleteById(id);
        return Mono.empty();
    }

    public Flux<CategoryCatalog> findByCategoryName(String categoryName) {
        return Flux.fromIterable(categoryCatalogRepository.findByCategoryName(categoryName));
    }

    // Otros métodos que puedas necesitar
}
