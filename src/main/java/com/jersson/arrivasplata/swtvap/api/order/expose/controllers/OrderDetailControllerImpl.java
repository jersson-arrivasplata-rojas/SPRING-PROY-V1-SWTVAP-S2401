package com.jersson.arrivasplata.swtvap.api.order.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.order.business.service.OrderDetailService;
import com.jersson.arrivasplata.swtvap.api.order.expose.OrderDetailController;
import com.jersson.arrivasplata.swtvap.api.order.mapper.OrderDetailMapper;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderDetail;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderDetailRequest;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderDetailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/orders-details", produces = "application/vnd.swtvap-api-orders-details.v1+json")
public class OrderDetailControllerImpl implements OrderDetailController {
    private final OrderDetailService orderDetailService;
    private final OrderDetailMapper orderDetailMapper;

    public OrderDetailControllerImpl(OrderDetailService orderDetailService, OrderDetailMapper orderDetailMapper) {
        this.orderDetailService = orderDetailService;
        this.orderDetailMapper = orderDetailMapper;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<OrderDetailResponse> getAllOrderDetail() {
        return orderDetailService.findAll()
                .map(orderDetail -> {
                    OrderDetailResponse orderDetailResponse = orderDetailMapper.orderDetailToOrderDetailResponse(orderDetail);
                    return orderDetailResponse;
                });
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrderDetailResponse> getOrderDetailById(@PathVariable Long id) {
        return orderDetailService.findById(id)
                .map(orderDetail -> {
                    OrderDetailResponse orderDetailResponse = orderDetailMapper.orderDetailToOrderDetailResponse(orderDetail);
                    return orderDetailResponse;
                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OrderDetailResponse> createOrderDetail(@RequestBody OrderDetailRequest orderDetailRequest) {
        OrderDetail orderDetail = orderDetailMapper.orderDetailRequestToOrderDetail(orderDetailRequest);

        return orderDetailService.save(orderDetail)
                .map(newOrderDetail -> {
                    OrderDetailResponse orderDetailResponse = orderDetailMapper.orderDetailToOrderDetailResponse(newOrderDetail);
                    return orderDetailResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrderDetailResponse> updateOrderDetail(@PathVariable Long id,@RequestBody OrderDetailRequest updatedOrderDetailRequest) {
        OrderDetail orderDetail = orderDetailMapper.orderDetailRequestToOrderDetail(updatedOrderDetailRequest);
        orderDetail.setOrderDetailId(id);

        return orderDetailService.updateOrderDetail(orderDetail)
                .map(updateOrderDetail->{
                    OrderDetailResponse orderDetailResponse = orderDetailMapper.orderDetailToOrderDetailResponse(updateOrderDetail);
                    return orderDetailResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteOrderDetail(@PathVariable Long id) {
        return orderDetailService.findById(id)
                .flatMap(existingOrderDetail -> {
                    orderDetailService.deleteById(id);
                    return Mono.empty();
                });
    }
}
