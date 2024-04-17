package com.jersson.arrivasplata.swtvap.api.cart.expose.controllers;


import com.jersson.arrivasplata.swtvap.api.cart.business.service.CartService;
import com.jersson.arrivasplata.swtvap.api.cart.expose.CartController;
import com.jersson.arrivasplata.swtvap.api.cart.mapper.CartMapper;
import com.jersson.arrivasplata.swtvap.api.cart.model.Cart;
import com.jersson.arrivasplata.swtvap.api.cart.model.CartRequest;
import com.jersson.arrivasplata.swtvap.api.cart.model.CartResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/carts", produces = "application/vnd.swtvap-api-cart.v1+json")
public class CartControllerImpl implements CartController {
    private final CartService cartService;
    private final CartMapper cartMapper;


    public CartControllerImpl(CartService cartService, CartMapper cartMapper) {
        this.cartService = cartService;
        this.cartMapper = cartMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<CartResponse> getAllCarts() {
        return cartService.getAllCarts()
                .map(cart -> {
                    CartResponse cartWithoutPropertyResponse = new CartResponse();
                    BeanUtils.copyProperties(cart, cartWithoutPropertyResponse, "cardDetails");

                    return cartWithoutPropertyResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CartResponse> getCartById(@PathVariable Long id) {
        return cartService.getCartById(id)
                .map(cart -> {
                    CartResponse cartWithoutPropertyResponse = new CartResponse();
                    BeanUtils.copyProperties(cart, cartWithoutPropertyResponse, "cardDetails");

                    return cartWithoutPropertyResponse;
                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CartResponse> createCart(@RequestBody CartRequest cartRequest) {
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartRequest, cart, "cardDetails");

        return cartService.createCart(cart)
                .map(newCart -> {
                    CartResponse cartWithoutPropertyResponse = new CartResponse();
                    BeanUtils.copyProperties(cart, cartWithoutPropertyResponse, "cardDetails");

                    return cartWithoutPropertyResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CartResponse> updateCart(@PathVariable Long id, @RequestBody CartRequest cartRequest) {

        cartRequest.setCartId(id);
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartRequest, cart, "cardDetails");

        return cartService.updateCart(cart)
                .map(updatedCart -> {
                    CartResponse cartWithoutPropertyResponse = new CartResponse();
                    BeanUtils.copyProperties(cart, cartWithoutPropertyResponse, "cardDetails");

                    return cartWithoutPropertyResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCart(@PathVariable Long id) {
        return cartService.deleteCartById(id);
    }

    // Implementa otros métodos del controlador si es necesario
}