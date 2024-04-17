package com.jersson.arrivasplata.swtvap.api.cart.business.service;

import com.jersson.arrivasplata.swtvap.api.cart.model.Cart;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CartService {
    Flux<Cart> getAllCarts();
    Mono<Cart> getCartById(Long id);
    Mono<Cart> createCart(Cart cart);
    Mono<Cart> updateCart(Cart cart);
    Mono<Void> deleteCartById(Long id);
    // Otros métodos relacionados con carto usando Reactor Core
}
