package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.WCategoryResponse;
import reactor.core.publisher.Flux;

public interface WCategoryController {
    Flux<WCategoryResponse> getAllCategories();
    // Otros métodos relacionados con catalogo usando Reactor Core
}
