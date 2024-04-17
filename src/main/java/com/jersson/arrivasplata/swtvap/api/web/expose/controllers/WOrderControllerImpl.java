package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WOrderService;
import com.jersson.arrivasplata.swtvap.api.web.expose.WOrderController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.WOrderMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.WCheckout;
import com.jersson.arrivasplata.swtvap.api.web.model.WOrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/w-orders", produces = "application/vnd.swtvap-api-w-orders.v1+json")

public class WOrderControllerImpl implements WOrderController {
    private final WOrderService orderService;
    private final WOrderMapper orderMapper;

    public WOrderControllerImpl(WOrderService orderService, WOrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<WOrderResponse> createOrder(@RequestBody WCheckout checkoutRequest) {

        return orderService.createOrder(checkoutRequest)
                .map(newOrder -> {
                    WOrderResponse orderResponse = orderMapper.orderToOrderResponse(newOrder);
                    return orderResponse;
                });
    }

}
