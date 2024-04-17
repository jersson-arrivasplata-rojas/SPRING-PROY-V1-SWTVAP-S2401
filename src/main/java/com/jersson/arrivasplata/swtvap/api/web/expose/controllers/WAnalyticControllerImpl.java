package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WAnalyticService;
import com.jersson.arrivasplata.swtvap.api.web.expose.WAnalyticController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.WAnalyticMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.WAnalytic;
import com.jersson.arrivasplata.swtvap.api.web.model.WAnalyticRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.WAnalyticResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/w-analytics", produces = "application/vnd.swtvap-api-w-analytics.v1+json")
public class WAnalyticControllerImpl implements WAnalyticController {
    private final WAnalyticService analyticService;
    private final WAnalyticMapper analyticMapper;


    public WAnalyticControllerImpl(WAnalyticService analyticService, WAnalyticMapper analyticMapper) {
        this.analyticService = analyticService;
        this.analyticMapper = analyticMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<WAnalyticResponse> createAnalytic(@RequestBody WAnalyticRequest analyticRequest) {
        WAnalytic analytic = analyticMapper.analyticRequestToAnalytic(analyticRequest);

        return analyticService.createAnalytic(analytic)
                .map(newAnalytic -> {
                    WAnalyticResponse analyticResponse = analyticMapper.analyticToAnalyticResponse(newAnalytic);
                    return analyticResponse;
                });
    }

    // Implementa otros métodos del controlador si es necesario
}