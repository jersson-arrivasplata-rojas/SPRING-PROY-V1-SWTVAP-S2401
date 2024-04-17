package com.jersson.arrivasplata.swtvap.api.cart.repository;

import com.jersson.arrivasplata.swtvap.api.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
    Cart findByCode(String name);
}

