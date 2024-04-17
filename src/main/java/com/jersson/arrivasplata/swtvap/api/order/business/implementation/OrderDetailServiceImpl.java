package com.jersson.arrivasplata.swtvap.api.order.business.implementation;

import com.jersson.arrivasplata.swtvap.api.order.business.service.OrderDetailService;
import com.jersson.arrivasplata.swtvap.api.order.enums.Status;
import com.jersson.arrivasplata.swtvap.api.order.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderDetail;
import com.jersson.arrivasplata.swtvap.api.order.repository.OrderDetailRepository;
import com.jersson.arrivasplata.swtvap.api.order.util.Common;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public Flux<OrderDetail> findAll() {
        return Flux.fromIterable(orderDetailRepository.findAll());
    }

    @Override
    public Mono<OrderDetail> findById(Long id) {
        return Mono.just(orderDetailRepository.findById(id)
                .orElseThrow(() -> new CustomException("OrderDetail not found with id: " + id)));
    }

    @Override
    public Mono<OrderDetail> save(OrderDetail orderDetail) { //Guardar
        if (orderDetail.getProductId() == null || orderDetail.getOrderId() == null ) {
            throw new CustomException("OrderDetail ProductId || OrderId is required");
        }
        return Mono.just(orderDetailRepository.save(orderDetail));
    }

    @Override
    public Mono<OrderDetail> updateOrderDetail(OrderDetail orderDetail) {
        if (orderDetail.getOrderDetailId() == null ) {
            throw new CustomException("OrderDetail id is required");
        }
        return Mono.just(orderDetailRepository.save(orderDetail));
    }

    @Override
    public Mono<Void> deleteById(Long id) {

        Optional<OrderDetail> orderDetailOptional = orderDetailRepository.findById(id);
        if (!orderDetailOptional.isPresent()) {
            throw new CustomException("OrderDetail not found with id: " + id);
        }
        OrderDetail orderDetail = orderDetailOptional.get();
        orderDetail.setStatus(Status.INACTIVE);
        orderDetail.setDeletedAt(Common.builder().build().getCurrentDate());
        orderDetailRepository.save(orderDetail);

        return Mono.empty();
    }

    @Override
    public Flux<OrderDetail> findByOrderCode(String orderCode) {
        return Flux.fromIterable(orderDetailRepository.findByOrderCode(orderCode));

    }
}
