package com.jersson.arrivasplata.swtvap.api.inventory.business.implementation;

import com.jersson.arrivasplata.swtvap.api.inventory.business.service.UnitService;
import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import com.jersson.arrivasplata.swtvap.api.inventory.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.common.model.Unit;
import com.jersson.arrivasplata.swtvap.api.inventory.repository.UnitRepository;
import com.jersson.arrivasplata.swtvap.api.inventory.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService {
    // Implementación de los métodos de la interfaz UnitService
    private final UnitRepository unitRepository;

    @Autowired
    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public Flux<Unit> getAllUnits() {
        return Flux.fromIterable(unitRepository.findAll());
    }

    public Mono<Unit> getUnitById(Long id) {
        return Mono.just(unitRepository.findById(id)
                .orElseThrow(() -> new CustomException("Unit not found with id: " + id)));
    }

    public Mono<Unit> createUnit(Unit unit) {
        // Lógica para crear una nueva unidad
        if (unit.getUnitName() == null || unit.getUnitName().isEmpty()) {
            throw new CustomException("Unit name is required.");
        }
        // Resto de la lógica para crear una unidad
        return Mono.just(unitRepository.save(unit));
    }

    public Mono<Unit> updateUnit(Unit unit) {
        // Lógica para actualizar una unidad
        if (unit.getUnitName() == null || unit.getUnitName().isEmpty()) {
            throw new CustomException("Unit name is required.");
        }
        // Resto de la lógica para actualizar una unidad
        return Mono.just(unitRepository.save(unit));
    }

    public Mono<Void> deleteUnitById(Long id) {
        // Lógica para eliminar una unidad
        Optional<Unit> unitOptional = unitRepository.findById(id);
        if (!unitOptional.isPresent()) {
            throw new CustomException("Unit not found with id: " + id);
        }
        // Resto de la lógica para eliminar una unidad
        Unit unit = unitOptional.get();

        unit.setStatus(Status.INACTIVE);
        unit.setDeletedAt(Common.builder().build().getCurrentDate());
        unitRepository.save(unit);

        return Mono.empty();
    }

    public Unit getUnitByName(String name) {
        // Implementación para recuperar la unidad por nombre desde el repositorio
        return unitRepository.findByUnitName(name);
    }
}
