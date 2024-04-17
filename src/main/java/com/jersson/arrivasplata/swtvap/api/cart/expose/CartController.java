package com.jersson.arrivasplata.swtvap.api.cart.expose;

import com.jersson.arrivasplata.swtvap.api.cart.model.CartRequest;
import com.jersson.arrivasplata.swtvap.api.cart.model.CartResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CartController {
    Flux<CartResponse> getAllCarts();
    Mono<CartResponse> getCartById(Long id);
    Mono<CartResponse> createCart(CartRequest cartRequest);
    Mono<CartResponse> updateCart(Long id, CartRequest cartRequest);
    Mono<Void> deleteCart(Long id);
    // Otros métodos relacionados con carto usando Reactor Core
}
