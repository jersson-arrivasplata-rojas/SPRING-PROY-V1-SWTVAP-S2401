package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WParameterService;
import com.jersson.arrivasplata.swtvap.api.web.expose.WParameterController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.WParameterMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.WParameterResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/w-parameters", produces = "application/vnd.swtvap-api-w-parameters.v1+json")
public class WParameterControllerImpl implements WParameterController {
    private final WParameterService parameterService;
    private final WParameterMapper parameterMapper;


    public WParameterControllerImpl(WParameterService parameterService, WParameterMapper parameterMapper) {
        this.parameterService = parameterService;
        this.parameterMapper = parameterMapper;
    }

    @GetMapping("/code/{codes}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<WParameterResponse> getStructureByCode(@PathVariable String codes) {
        String[] codesArray = codes.split(",");
        return Flux.fromArray(codesArray)
                .flatMap(code -> Mono.just(parameterService.getStructureByCode(code))
                        .map(data -> parameterMapper.toParameterResponse(data))
                );
    }
}
