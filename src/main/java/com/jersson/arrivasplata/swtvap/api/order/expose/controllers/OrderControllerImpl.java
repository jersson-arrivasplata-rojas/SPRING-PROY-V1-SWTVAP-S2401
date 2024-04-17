package com.jersson.arrivasplata.swtvap.api.order.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.order.business.service.OrderService;
import com.jersson.arrivasplata.swtvap.api.order.expose.OrderController;
import com.jersson.arrivasplata.swtvap.api.order.mapper.OrderMapper;
import com.jersson.arrivasplata.swtvap.api.common.model.Order;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/orders", produces = "application/vnd.swtvap-api-orders.v1+json")

public class OrderControllerImpl implements OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderControllerImpl(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @GetMapping("/order-summary")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Object> getOrderSummary() {
        return orderService.getOrderSummary();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<OrderResponse> getAllOrders() {
        return orderService.getAllOrders()
                .map(order -> {
                    OrderResponse orderResponse = orderMapper.orderToOrderResponse(order);
                    return orderResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Mono<OrderResponse> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(order -> {
                    OrderResponse orderResponse = orderMapper.orderToOrderResponse(order);
                    return orderResponse;

                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderMapper.orderRequestToOrder(orderRequest);

        return orderService.createOrder(order)
                .map(newOrder -> {
                    OrderResponse orderResponse = orderMapper.orderToOrderResponse(newOrder);
                    return orderResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrderResponse> updateOrder( @PathVariable  Long id,  @RequestBody  OrderRequest orderRequest) {
        Order order = orderMapper.orderRequestToOrder(orderRequest);
        order.setOrderId(id);
        return orderService.updateOrder(order)
                .map(updateOrder -> {
                    OrderResponse orderResponse = orderMapper.orderToOrderResponse(updateOrder);
                    return orderResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrderById(id);
    }
}
