package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WAnalyticService;
import com.jersson.arrivasplata.swtvap.api.web.model.WAnalytic;
import com.jersson.arrivasplata.swtvap.api.web.repository.WAnalyticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WAnalyticServiceImpl implements WAnalyticService {

    private final WAnalyticRepository WAnalyticRepository;

    @Autowired
    public WAnalyticServiceImpl(WAnalyticRepository WAnalyticRepository) {
        this.WAnalyticRepository = WAnalyticRepository;
    }

    public Mono<WAnalytic> createAnalytic(WAnalytic analytic) {
        // Lógica para crear un nuevo analytic
        return Mono.just(WAnalyticRepository.save(analytic));
    }
}