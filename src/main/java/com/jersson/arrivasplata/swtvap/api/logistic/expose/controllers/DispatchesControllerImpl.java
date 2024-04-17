package com.jersson.arrivasplata.swtvap.api.logistic.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.logistic.business.service.DispatchesService;
import com.jersson.arrivasplata.swtvap.api.logistic.expose.DispatchesController;
import com.jersson.arrivasplata.swtvap.api.logistic.mapper.DispatchesMapper;
import com.jersson.arrivasplata.swtvap.api.logistic.model.Dispatches;
import com.jersson.arrivasplata.swtvap.api.logistic.model.DispatchesRequest;
import com.jersson.arrivasplata.swtvap.api.logistic.model.DispatchesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/dispatches", produces = "application/vnd.swtvap-api-dispatches.v1+json")
public class DispatchesControllerImpl implements DispatchesController{
    private final DispatchesService dispatchesService;
    private final DispatchesMapper dispatchesMapper;


    public DispatchesControllerImpl(DispatchesService dispatchesService, DispatchesMapper dispatchesMapper) {
        this.dispatchesService = dispatchesService;
        this.dispatchesMapper = dispatchesMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<DispatchesResponse> getAllDispatches() {
        return dispatchesService.getAllDispatches()
                .map(dispatches -> {
                    DispatchesResponse dispatchesResponse = dispatchesMapper.dispatchesToDispatchesResponse(dispatches);
                    return dispatchesResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DispatchesResponse> getDispatchesById(@PathVariable Long id) {
        return dispatchesService.getDispatchesById(id)
                .map(dispatches -> {
                    DispatchesResponse dispatchesResponse = dispatchesMapper.dispatchesToDispatchesResponse(dispatches);
                    return dispatchesResponse;
                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<DispatchesResponse> createDispatches(@RequestBody DispatchesRequest dispatchesRequest) {
        Dispatches dispatches = dispatchesMapper.dispatchesRequestToDispatches(dispatchesRequest);

        return dispatchesService.createDispatches(dispatches)
                .map(newDispatches -> {
                    DispatchesResponse dispatchesResponse = dispatchesMapper.dispatchesToDispatchesResponse(newDispatches);
                    return dispatchesResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DispatchesResponse> updateDispatches(@PathVariable Long id, @RequestBody DispatchesRequest dispatchesRequest) {
        Dispatches dispatches = dispatchesMapper.dispatchesRequestToDispatches(dispatchesRequest);
        dispatches.setId(id);
        return dispatchesService.updateDispatches(dispatches)
                .map(updatedDispatches -> {
                    DispatchesResponse dispatchesResponse = dispatchesMapper.dispatchesToDispatchesResponse(updatedDispatches);
                    return dispatchesResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteDispatches(@PathVariable Long id) {
        return dispatchesService.deleteDispatchesById(id);

    }
}
