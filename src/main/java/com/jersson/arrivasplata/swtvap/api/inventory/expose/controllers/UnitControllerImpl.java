package com.jersson.arrivasplata.swtvap.api.inventory.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.common.util.UtilityService;
import com.jersson.arrivasplata.swtvap.api.inventory.business.service.UnitService;
import com.jersson.arrivasplata.swtvap.api.inventory.expose.UnitController;
import com.jersson.arrivasplata.swtvap.api.inventory.mapper.UnitMapper;
import com.jersson.arrivasplata.swtvap.api.common.model.Unit;
import com.jersson.arrivasplata.swtvap.api.common.model.UnitRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.UnitResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/units", produces = "application/vnd.swtvap-api-unit.v1+json")
public class UnitControllerImpl implements UnitController {
    private final UnitService unitService;
    private final UtilityService utilityService;
    private final UnitMapper unitMapper;


    public UnitControllerImpl(UnitService unitService, UnitMapper unitMapper, UtilityService utilityService) {
        this.unitService = unitService;
        this.unitMapper = unitMapper;
        this.utilityService = utilityService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<UnitResponse> getAllUnits() {
        return unitService.getAllUnits()
                .map(unit -> {
                    UnitResponse unitResponse = unitMapper.unitToUnitResponse(unit);
                    return unitResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<UnitResponse> getUnitById(@PathVariable Long id) {
        return unitService.getUnitById(id)
                .map(unit -> {
                    UnitResponse unitResponse = unitMapper.unitToUnitResponse(unit);
                    return unitResponse;

                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UnitResponse> createUnit(@RequestBody UnitRequest unitRequest) {
        Unit unit = unitMapper.unitRequestToUnit(unitRequest);

        return unitService.createUnit(unit)
                .map(newUnit -> {
                    UnitResponse unitResponse = unitMapper.unitToUnitResponse(newUnit);
                    return unitResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<UnitResponse> updateUnit(@PathVariable Long id, @RequestBody UnitRequest unitRequest) {
        Unit unit = unitMapper.unitRequestToUnit(unitRequest);
        unit.setUnitId(id);
        return unitService.updateUnit(unit)
                .map(updatedUnit -> {
                    UnitResponse unitResponse = unitMapper.unitToUnitResponse(updatedUnit);
                    return unitResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUnit(@PathVariable Long id) {
        return unitService.deleteUnitById(id);
    }

    // Implementa otros métodos del controlador si es necesario
}
