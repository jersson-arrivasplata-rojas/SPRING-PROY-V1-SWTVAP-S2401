package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WCategoryService;
import com.jersson.arrivasplata.swtvap.api.web.expose.WCategoryController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.WCategoryMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.WCategoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping(value = "/api/w-categories", produces = "application/vnd.swtvap-api-w-category.v1+json")
public class WCategoryControllerImpl implements WCategoryController {

    private final WCategoryService categoryService;
    private final WCategoryMapper categoryMapper;


    public WCategoryControllerImpl(WCategoryService categoryService, WCategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<WCategoryResponse> getAllCategories() {
       return Flux.fromIterable(categoryService.getAllCategories())
                .map(category -> {
                    WCategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(category);
                    return categoryResponse;
                });
    }

    // Implementa otros métodos del controlador si es necesario
}