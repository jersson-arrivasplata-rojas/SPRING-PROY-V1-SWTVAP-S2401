package com.jersson.arrivasplata.swtvap.api.inventory.expose;

import com.jersson.arrivasplata.swtvap.api.common.model.UnitRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.UnitResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UnitController {
    Flux<UnitResponse> getAllUnits();
    Mono<UnitResponse> getUnitById(Long id);
    Mono<UnitResponse> createUnit(UnitRequest unitRequest);
    Mono<UnitResponse> updateUnit(Long id, UnitRequest unitRequest);
    Mono<Void> deleteUnit(Long id);
    // Otros métodos relacionados con catalogo usando Reactor Core
}
