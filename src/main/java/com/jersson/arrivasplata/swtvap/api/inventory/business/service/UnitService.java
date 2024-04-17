package com.jersson.arrivasplata.swtvap.api.inventory.business.service;

import com.jersson.arrivasplata.swtvap.api.common.model.Unit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UnitService {
    Flux<Unit> getAllUnits();
    Mono<Unit> getUnitById(Long id);
    Mono<Unit> createUnit(Unit unit);
    Mono<Unit> updateUnit(Unit unit);
    Mono<Void> deleteUnitById(Long id);
    // Otros métodos relacionados con unidades
}
