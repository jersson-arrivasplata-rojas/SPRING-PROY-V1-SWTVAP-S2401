package com.jersson.arrivasplata.swtvap.api.cart.business.implementation;

import com.jersson.arrivasplata.swtvap.api.cart.business.service.CartDetailService;
import com.jersson.arrivasplata.swtvap.api.cart.model.CartDetail;
import com.jersson.arrivasplata.swtvap.api.cart.repository.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CartDetailServiceImpl implements CartDetailService {
    private final CartDetailRepository cartDetailRepository;

    @Autowired
    public CartDetailServiceImpl(CartDetailRepository cartDetailRepository) {
        this.cartDetailRepository = cartDetailRepository;
    }


    public Flux<CartDetail> findAll() {
        return Flux.fromIterable(cartDetailRepository.findAll());
    }

    public Mono<CartDetail> findById(Long id) {
        return Mono.justOrEmpty(cartDetailRepository.findById(id));
    }

    public Mono<CartDetail> save(CartDetail cartDetail) {
        return Mono.justOrEmpty(cartDetailRepository.save(cartDetail));
    }

    public Mono<Void> deleteById(Long id) {
        cartDetailRepository.deleteById(id);
        return Mono.empty();
    }

    public Flux<CartDetail> findByProductName(String productName) {
        return Flux.fromIterable(cartDetailRepository.findByProductName(productName));
    }

    // Otros métodos que puedas necesitar
}
