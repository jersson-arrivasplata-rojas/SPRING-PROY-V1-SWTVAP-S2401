package com.jersson.arrivasplata.swtvap.api.order.business.implementation;

import com.jersson.arrivasplata.swtvap.api.order.business.service.OrderTransactionService;
import com.jersson.arrivasplata.swtvap.api.order.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderTransaction;
import com.jersson.arrivasplata.swtvap.api.order.repository.OrderTransactionRepository;
import com.jersson.arrivasplata.swtvap.api.order.util.Common;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class OrderTransactionServiceImpl implements OrderTransactionService {
    private final OrderTransactionRepository orderTransactionRepository;

    public OrderTransactionServiceImpl(OrderTransactionRepository orderTransactionRepository) {
        this.orderTransactionRepository = orderTransactionRepository;
    }

    @Override
    public Flux<OrderTransaction> findAll() {
        return Flux.fromIterable(orderTransactionRepository.findAll());
    }

    @Override
    public Mono<OrderTransaction> findById(Long id) {
        return Mono.justOrEmpty(orderTransactionRepository.findById(id));
    }

    @Override
    public Mono<OrderTransaction> save(OrderTransaction orderTransaction) {
        return Mono.justOrEmpty(orderTransactionRepository.save(orderTransaction));
    }

    @Override
    public Mono<Void> deleteById(Long id) {

        // Lógica para eliminar un orderTransaction
        Optional<OrderTransaction> orderTransactionOptional = orderTransactionRepository.findById(id);
        if (!orderTransactionOptional.isPresent()) {
            throw new CustomException("OrderTransaction not found with id: " + id);
        }
        // Resto de la lógica para eliminar un orderTransaction

        OrderTransaction orderTransaction = orderTransactionOptional.get();
        orderTransaction.setDeletedAt(Common.builder().build().getCurrentDate());
        orderTransactionRepository.save(orderTransaction);

        return Mono.empty();
    }

    @Override
    public Flux<OrderTransaction> findByOrderCode(String orderCode) {
        return Flux.fromIterable(orderTransactionRepository.findByOrderCode(orderCode));
    }
}
