package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WCatalogService;
import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import com.jersson.arrivasplata.swtvap.api.web.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.web.model.WCatalog;
import com.jersson.arrivasplata.swtvap.api.web.model.WCategory;
import com.jersson.arrivasplata.swtvap.api.web.model.WProduct;
import com.jersson.arrivasplata.swtvap.api.web.repository.WCatalogRepository;
import com.jersson.arrivasplata.swtvap.api.web.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WCatalogServiceImpl implements WCatalogService {

    private final WCatalogRepository WCatalogRepository;

    @Autowired
    public WCatalogServiceImpl(WCatalogRepository WCatalogRepository) {
        this.WCatalogRepository = WCatalogRepository;
    }

    @Override
    public Flux<WCatalog> getAllCatalogs() {
        return Flux.fromIterable(WCatalogRepository.findAll())////Lang.valueOf(lang.toUpperCase())
                .filter(catalog -> Status.ACTIVE.name().equals(catalog.getStatus().name()) && catalog.getDeletedAt() == null)
                .map(catalog -> {

                    List<WProduct> filteredProducts = catalog.getProducts().stream()
                            .filter(product -> product.getStatus() == Status.ACTIVE && product.getDeletedAt() == null)
                            .map(productCatalog -> Common.builder().build().filterProduct(productCatalog))
                            .collect(Collectors.toList());
                    catalog.setProducts(new HashSet<>(filteredProducts));

                    List<WCategory> filteredCategories = catalog.getCategories().stream()
                            .filter(category -> category.getStatus() == Status.ACTIVE && category.getDeletedAt() == null)
                            .map(category -> {
                                List<WProduct> filteredCategoryProducts = category.getProducts().stream()
                                        .filter(product -> product.getStatus() == Status.ACTIVE && product.getDeletedAt() == null)
                                        .map(product -> Common.builder().build().filterProduct(product))
                                        .collect(Collectors.toList());
                                category.setProducts(new HashSet<>(filteredCategoryProducts));
                                return category;
                            })
                            .collect(Collectors.toList());
                    catalog.setCategories(new HashSet<>(filteredCategories));

                    return catalog;
                })
                .switchIfEmpty(Mono.error(new CustomException("Catalog not found")));
    }


    @Override
    public Flux<WCatalog> getAllCatalogByCode(String code) {
        return Flux.fromIterable(WCatalogRepository.findAllByCode(code))
                .filter(catalog -> Status.ACTIVE.name().equals(catalog.getStatus().name()) && catalog.getDeletedAt() == null)
                .map(catalog -> {

                    List<WProduct> filteredProducts = catalog.getProducts().stream()
                            .filter(product -> product.getStatus() == Status.ACTIVE && product.getDeletedAt() == null)
                            .map(productCatalog -> Common.builder().build().filterProduct(productCatalog))
                            .collect(Collectors.toList());
                    catalog.setProducts(new HashSet<>(filteredProducts));

                    List<WCategory> filteredCategories = catalog.getCategories().stream()
                            .filter(category -> category.getStatus() == Status.ACTIVE && category.getDeletedAt() == null)
                            .map(category -> {
                                List<WProduct> filteredCategoryProducts = category.getProducts().stream()
                                        .filter(product -> product.getStatus() == Status.ACTIVE && product.getDeletedAt() == null)
                                        .map(product -> Common.builder().build().filterProduct(product))
                                        .collect(Collectors.toList());
                                category.setProducts(new HashSet<>(filteredCategoryProducts));
                                return category;
                            })
                            .collect(Collectors.toList());
                    catalog.setCategories(new HashSet<>(filteredCategories));

                    return catalog;
                })
                .switchIfEmpty(Mono.error(new CustomException("Catalog not found with code: " + code)));
    }
}