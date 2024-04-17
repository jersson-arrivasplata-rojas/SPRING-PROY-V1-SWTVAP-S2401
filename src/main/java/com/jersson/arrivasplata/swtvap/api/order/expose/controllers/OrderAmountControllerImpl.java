package com.jersson.arrivasplata.swtvap.api.order.expose.controllers;
import com.jersson.arrivasplata.swtvap.api.order.business.service.OrderAmountService;
import com.jersson.arrivasplata.swtvap.api.order.expose.OrderAmountController;
import com.jersson.arrivasplata.swtvap.api.order.mapper.OrderAmountMapper;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderAmount;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderAmountRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderAmountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/orders-amounts", produces = "application/vnd.swtvap-api-orders-amounts.v1+json")
public class OrderAmountControllerImpl implements OrderAmountController {
    private final OrderAmountService orderAmountService;
    private final OrderAmountMapper orderAmountMapper;

    public OrderAmountControllerImpl(OrderAmountService orderAmountService, OrderAmountMapper orderAmountMapper) {
        this.orderAmountService = orderAmountService;
        this.orderAmountMapper = orderAmountMapper;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<OrderAmountResponse> getAllOrderAmount() {
        return orderAmountService.getAllOrderAmount()
                .map(orderAmount -> {
            OrderAmountResponse orderAmountResponse = orderAmountMapper.orderAmountToOrderAmountResponse(orderAmount);
            return orderAmountResponse;
        });
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrderAmountResponse> getOrderAmountById(@PathVariable Long id) {
        return orderAmountService.getOrderAmountById(id)
                .map(orderAmount -> {
                    OrderAmountResponse orderAmountResponse = orderAmountMapper.orderAmountToOrderAmountResponse(orderAmount);
                    return orderAmountResponse;
                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OrderAmountResponse> createOrderAmount(@RequestBody OrderAmountRequest orderAmountRequest) {
        OrderAmount orderAmount = orderAmountMapper.orderAmountRequestToOrderAmount(orderAmountRequest);

        return orderAmountService.createOrderAmount(orderAmount)
                .map(newOrderAmount -> {
                    OrderAmountResponse orderAmountResponse = orderAmountMapper.orderAmountToOrderAmountResponse(newOrderAmount);
                    return orderAmountResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrderAmountResponse> updateOrderAmount(@PathVariable Long id,@RequestBody OrderAmountRequest orderAmountRequest) {
        OrderAmount orderAmount = orderAmountMapper.orderAmountRequestToOrderAmount(orderAmountRequest);
        orderAmount.setOrderAmountId(id);
        return orderAmountService.updateOrderAmount(orderAmount)
                .map(updatedOrderAmount -> {
                    OrderAmountResponse orderAmountResponse = orderAmountMapper.orderAmountToOrderAmountResponse(updatedOrderAmount);
                    return orderAmountResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteOrderAmount(@PathVariable Long id) {
        return orderAmountService.getOrderAmountById(id)
                .flatMap(existingOrderAmount -> {
                    orderAmountService.deleteOrderAmount(id);
                    return Mono.empty();
                });
    }
}
