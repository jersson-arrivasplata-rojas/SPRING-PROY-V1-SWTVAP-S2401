package com.jersson.arrivasplata.swtvap.api.cart.mapper;

import com.jersson.arrivasplata.swtvap.api.cart.model.Cart;
import com.jersson.arrivasplata.swtvap.api.cart.model.CartRequest;
import com.jersson.arrivasplata.swtvap.api.cart.model.CartResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    //@Mapping(target = "id", ignore = true)
    Cart cartRequestToCart(CartRequest cartRequest);

    CartRequest cartToCartRequest(Cart cart);

    CartResponse cartToCartResponse(Cart cart);

    List<CartResponse> mapCartsToResponses(List<Cart> carts);
}
