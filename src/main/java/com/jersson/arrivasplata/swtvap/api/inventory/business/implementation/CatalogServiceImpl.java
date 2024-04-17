package com.jersson.arrivasplata.swtvap.api.inventory.business.implementation;

import com.jersson.arrivasplata.swtvap.api.inventory.business.service.CatalogService;
import com.jersson.arrivasplata.swtvap.api.inventory.enums.StatusCatalog;
import com.jersson.arrivasplata.swtvap.api.inventory.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.common.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.inventory.repository.CatalogRepository;
import com.jersson.arrivasplata.swtvap.api.inventory.repository.CategoryCatalogRepository;
import com.jersson.arrivasplata.swtvap.api.inventory.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;
    private final CategoryCatalogRepository categoryCatalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository, CategoryCatalogRepository categoryCatalogRepository) {
        this.catalogRepository = catalogRepository;
        this.categoryCatalogRepository = categoryCatalogRepository;
    }

    @Override
    public Flux<Catalog> getAllCatalogs() {
        return Flux.fromIterable(catalogRepository.findAll());
    }

    public Mono<Catalog> getCatalogById(Long id) {
        return Mono.just(catalogRepository.findById(id)
                .orElseThrow(() -> new CustomException("Catalog not found with id: " + id)));
    }

    public Mono<Catalog> createCatalog(Catalog catalog) {
        // Lógica para crear una nuevo catalogo
        if (catalog.getName() == null || catalog.getName().isEmpty()) {
            throw new CustomException("Catalog name is required.");
        }
        // Resto de la lógica para crear un catalogo
        return Mono.just(catalogRepository.save(catalog));
    }

    public Mono<Catalog> updateCatalog(Catalog catalog) {
        // Lógica para actualizar un catalogo
        if (catalog.getName() == null || catalog.getName().isEmpty()) {
            throw new CustomException("Catalog name is required.");
        }
        // Resto de la lógica para actualizar un catalogo
        return Mono.just(catalogRepository.save(catalog));
    }

    public Mono<Void> deleteCatalogById(Long id) {
        // Lógica para eliminar un catalogo
        Optional<Catalog> catalogOptional = catalogRepository.findById(id);
        if (!catalogOptional.isPresent()) {
            throw new CustomException("Catalog not found with id: " + id);
        }
        // Resto de la lógica para eliminar un catalogo
        Catalog catalog = catalogOptional.get();

        //categoryCatalogRepository.deleteByCategoryCategoryId(catalog.getCatalogId());

        catalog.setStatus(StatusCatalog.INACTIVE);
        catalog.setDeletedAt(Common.builder().build().getCurrentDate());
        catalogRepository.save(catalog);

        return Mono.empty();
    }

    public Catalog getCatalogByName(String name) {
        // Implementación para recuperar el catalogo por nombre desde el repositorio
        return catalogRepository.findByName(name);
    }
}