package com.jersson.arrivasplata.swtvap.api.campaing.business.implementation;

import com.jersson.arrivasplata.swtvap.api.campaing.business.service.AnalyticService;
import com.jersson.arrivasplata.swtvap.api.campaing.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.campaing.model.Analytic;
import com.jersson.arrivasplata.swtvap.api.campaing.repository.AnalyticRepository;
import com.jersson.arrivasplata.swtvap.api.campaing.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class AnalyticServiceImpl implements AnalyticService {

    private final AnalyticRepository analyticRepository;

    @Autowired
    public AnalyticServiceImpl(AnalyticRepository analyticRepository) {
        this.analyticRepository = analyticRepository;
    }

    @Override
    public Flux<Analytic> getAllAnalytics() {
        return Flux.fromIterable(analyticRepository.findAll());
    }

    public Mono<Analytic> getAnalyticById(Long id) {
        return Mono.just(analyticRepository.findById(id)
                .orElseThrow(() -> new CustomException("Analytic not found with id: " + id)));
    }

    public Mono<Analytic> createAnalytic(Analytic analytic) {
        // Lógica para crear un nuevo analytic
        return Mono.just(analyticRepository.save(analytic));
    }

    public Mono<Analytic> updateAnalytic(Analytic analytic) {
        // Lógica para actualizar un analytic
        if (analytic.getAnalyticId() == null) {
            throw new CustomException("Analytic id is required.");
        }
        // Resto de la lógica para actualizar un analytico
        return Mono.just(analyticRepository.save(analytic));
    }

    public Mono<Void> deleteAnalyticById(Long id) {
        // Lógica para eliminar un analytic
        Optional<Analytic> analyticOptional = analyticRepository.findById(id);
        if (!analyticOptional.isPresent()) {
            throw new CustomException("Analytic not found with id: " + id);
        }
        // Resto de la lógica para eliminar un analytic
        Analytic analytic = analyticOptional.get();
        analytic.setDeletedAt(Common.builder().build().getCurrentDate());
        analyticRepository.save(analytic);

        return Mono.empty();
    }
}