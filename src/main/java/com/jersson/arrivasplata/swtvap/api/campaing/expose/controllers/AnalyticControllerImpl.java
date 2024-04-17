package com.jersson.arrivasplata.swtvap.api.campaing.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.campaing.business.service.AnalyticService;
import com.jersson.arrivasplata.swtvap.api.campaing.expose.AnalyticController;
import com.jersson.arrivasplata.swtvap.api.campaing.mapper.AnalyticMapper;
import com.jersson.arrivasplata.swtvap.api.campaing.model.Analytic;
import com.jersson.arrivasplata.swtvap.api.campaing.model.AnalyticRequest;
import com.jersson.arrivasplata.swtvap.api.campaing.model.AnalyticResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/analytics", produces = "application/vnd.swtvap-api-analytics.v1+json")
public class AnalyticControllerImpl implements AnalyticController {
    private final AnalyticService analyticService;
    private final AnalyticMapper analyticMapper;


    public AnalyticControllerImpl(AnalyticService analyticService, AnalyticMapper analyticMapper) {
        this.analyticService = analyticService;
        this.analyticMapper = analyticMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<AnalyticResponse> getAllAnalytics() {
        return analyticService.getAllAnalytics()
                .map(analytic -> {
                    AnalyticResponse analyticResponse = analyticMapper.analyticToAnalyticResponse(analytic);
                    return analyticResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<AnalyticResponse> getAnalyticById(@PathVariable Long id) {
        return analyticService.getAnalyticById(id)
                .map(analytic -> {
                    AnalyticResponse analyticResponse = analyticMapper.analyticToAnalyticResponse(analytic);
                    return analyticResponse;

                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AnalyticResponse> createAnalytic(@RequestBody AnalyticRequest analyticRequest) {
        Analytic analytic = analyticMapper.analyticRequestToAnalytic(analyticRequest);

        return analyticService.createAnalytic(analytic)
                .map(newAnalytic -> {
                    AnalyticResponse analyticResponse = analyticMapper.analyticToAnalyticResponse(newAnalytic);
                    return analyticResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<AnalyticResponse> updateAnalytic(@PathVariable Long id, @RequestBody AnalyticRequest analyticRequest) {
        Analytic analytic = analyticMapper.analyticRequestToAnalytic(analyticRequest);
        analytic.setAnalyticId(id);
        return analyticService.updateAnalytic(analytic)
                .map(updatedAnalytic -> {
                    AnalyticResponse analyticResponse = analyticMapper.analyticToAnalyticResponse(updatedAnalytic);
                    return analyticResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAnalytic(@PathVariable Long id) {
        return analyticService.deleteAnalyticById(id);
    }

    // Implementa otros métodos del controlador si es necesario
}