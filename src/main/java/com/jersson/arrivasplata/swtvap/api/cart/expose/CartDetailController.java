package com.jersson.arrivasplata.swtvap.api.cart.expose;

import com.jersson.arrivasplata.swtvap.api.cart.model.CartDetail;
import reactor.core.publisher.Mono;

public interface CartDetailController {
    Mono<CartDetail> getCartDetailById(Long id);

    Mono<CartDetail> createCartDetail(CartDetail cartDetail);

    Mono<CartDetail> updateCartDetail(Long id, CartDetail updatedCartDetail);

    Mono<Void> deleteCartDetail(Long id);

}
