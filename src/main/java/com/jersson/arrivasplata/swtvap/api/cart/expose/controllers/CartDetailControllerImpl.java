package com.jersson.arrivasplata.swtvap.api.cart.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.cart.business.service.CartDetailService;
import com.jersson.arrivasplata.swtvap.api.cart.expose.CartDetailController;
import com.jersson.arrivasplata.swtvap.api.cart.model.CartDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/cart-details", produces = "application/vnd.swtvap-api-cart-details.v1+json")
public class CartDetailControllerImpl implements CartDetailController {
    private final CartDetailService cartDetailService;

    public CartDetailControllerImpl(CartDetailService cartDetailService) {
        this.cartDetailService = cartDetailService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<CartDetail> getAllCartDetails() {
        return cartDetailService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CartDetail> getCartDetailById(@PathVariable Long id) {
        return cartDetailService.findById(id)
                .map(cartDetail -> cartDetail);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CartDetail> createCartDetail(@RequestBody CartDetail cartDetail) {
        return cartDetailService.save(cartDetail)
                .map(newCartDetail -> newCartDetail);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CartDetail> updateCartDetail(@PathVariable Long id, @RequestBody CartDetail updatedCartDetail) {
        return cartDetailService.findById(id)
                .flatMap(existingCartDetail -> {
                    updatedCartDetail.setCartDetailId(id);
                    return cartDetailService.save(updatedCartDetail);
                })
                .map(updated -> updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCartDetail(@PathVariable Long id) {
        return cartDetailService.findById(id)
                .flatMap(existingCartDetail -> {
                    cartDetailService.deleteById(id);
                    return Mono.empty();
                });
    }
}
