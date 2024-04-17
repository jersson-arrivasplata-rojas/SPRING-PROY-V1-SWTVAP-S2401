package com.jersson.arrivasplata.swtvap.api.setting.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.setting.business.service.ParameterService;
import com.jersson.arrivasplata.swtvap.api.setting.expose.ParameterController;
import com.jersson.arrivasplata.swtvap.api.setting.mapper.ParameterMapper;
import com.jersson.arrivasplata.swtvap.api.setting.model.Parameter;
import com.jersson.arrivasplata.swtvap.api.setting.model.ParameterRequest;
import com.jersson.arrivasplata.swtvap.api.setting.model.ParameterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/parameters", produces = "application/vnd.swtvap-api-parameter.v1+json")
public class ParameterControllerImpl implements ParameterController {
    private final ParameterService parameterService;
    private final ParameterMapper parameterMapper;

    public ParameterControllerImpl(ParameterService parameterService, ParameterMapper parameterMapper) {
        this.parameterService = parameterService;
        this.parameterMapper = parameterMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ParameterResponse> getAllParameters() {
        return Flux.fromIterable(parameterService.getAllParameters())
                .map(parameter -> {
                    ParameterResponse parameterResponse = parameterMapper.parameterToParameterResponse(parameter);
                    return parameterResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ParameterResponse> getParameterById(@PathVariable Long id) {
        return Mono.just(parameterService.getParameterById(id))
                .map(parameter -> {
                    ParameterResponse parameterResponse = parameterMapper.parameterToParameterResponse(parameter);
                    return parameterResponse;
                })
                .defaultIfEmpty(new ParameterResponse());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ParameterResponse> createParameter(@RequestBody ParameterRequest parameterRequest) {
        Parameter parameter = parameterMapper.parameterRequestToParameter(parameterRequest);

        return Mono.just(parameterService.createParameter(parameter))
                .map(newParameter -> {
                    ParameterResponse parameterResponse = parameterMapper.parameterToParameterResponse(newParameter);
                    return parameterResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ParameterResponse> updateParameter(@PathVariable Long id, @RequestBody ParameterRequest parameterRequest) {
        Parameter parameter = parameterMapper.parameterRequestToParameter(parameterRequest);

        return Mono.just(parameterService.updateParameter(id, parameter))
                .map(updatedParameter -> {
                    ParameterResponse parameterResponse = parameterMapper.parameterToParameterResponse(updatedParameter);
                    return parameterResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteParameter(@PathVariable Long id) {
        parameterService.deleteParameterById(id);
        return Mono.empty();
    }
}
