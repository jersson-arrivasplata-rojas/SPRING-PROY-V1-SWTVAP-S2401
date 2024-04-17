package com.jersson.arrivasplata.swtvap.api.order.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.order.business.service.OrderTransactionService;
import com.jersson.arrivasplata.swtvap.api.order.expose.OrderTransactionController;
import com.jersson.arrivasplata.swtvap.api.order.mapper.OrderTransactionMapper;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderTransaction;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderTransactionRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderTransactionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/orders-transactions", produces = "application/vnd.swtvap-api-orders-transactions.v1+json")
public class OrderTransactionControllerImpl implements OrderTransactionController {
    private final OrderTransactionService orderTransactionService;
    private final OrderTransactionMapper orderTransactionMapper;

    public OrderTransactionControllerImpl(OrderTransactionService orderTransactionService, OrderTransactionMapper orderTransactionMapper) {
        this.orderTransactionService = orderTransactionService;
        this.orderTransactionMapper = orderTransactionMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<OrderTransactionResponse> getAllOrderTransaction() {
        return orderTransactionService.findAll()
                .map(orderTransaction -> {
                    OrderTransactionResponse orderTransactionResponse = orderTransactionMapper.orderTransactionToOrderTransactionResponse(orderTransaction);
                    return orderTransactionResponse;
                });
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrderTransactionResponse> getOrderTransactionById(@PathVariable Long id) {
        return orderTransactionService.findById(id)
                .map(orderTransaction -> {
                    OrderTransactionResponse orderTransactionResponse = orderTransactionMapper.orderTransactionToOrderTransactionResponse(orderTransaction);
                    return orderTransactionResponse;
                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OrderTransactionResponse> createOrderTransaction(@RequestBody OrderTransactionRequest orderTransactionRequest) {
        OrderTransaction orderTransaction = orderTransactionMapper.orderTransactionRequestToOrderTransaction(orderTransactionRequest);

        return orderTransactionService.save(orderTransaction)
                .map(newOrderTransaction -> {
                    OrderTransactionResponse orderTransactionResponse = orderTransactionMapper.orderTransactionToOrderTransactionResponse(orderTransaction);
                    return orderTransactionResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrderTransactionResponse> updateOrderTransaction(@PathVariable Long id, @RequestBody OrderTransactionRequest orderTransactionRequest) {
        OrderTransaction orderTransaction = orderTransactionMapper.orderTransactionRequestToOrderTransaction(orderTransactionRequest);
        orderTransaction.setOrderTransactionId(id);

        return orderTransactionService.save(orderTransaction)
                .map(updatedOrderTransaction -> {
                    OrderTransactionResponse orderTransactionResponse = orderTransactionMapper.orderTransactionToOrderTransactionResponse(updatedOrderTransaction);
                    return orderTransactionResponse;

                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteOrderTransaction(@PathVariable Long id) {
        return orderTransactionService.findById(id)
                .flatMap(existingOrderTransaction -> {
                    orderTransactionService.deleteById(id);
                    return Mono.empty();
                });
    }
}
