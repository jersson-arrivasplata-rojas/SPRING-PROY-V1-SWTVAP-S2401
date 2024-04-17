package com.jersson.arrivasplata.swtvap.api.cart.repository;

import com.jersson.arrivasplata.swtvap.api.cart.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios

    List<CartDetail> findAll(); // Obtiene todos los registros

    void deleteById(Long id); // Elimina por ID

    List<CartDetail> findByProductName(String productName); // Busca por nombre de producto
}

