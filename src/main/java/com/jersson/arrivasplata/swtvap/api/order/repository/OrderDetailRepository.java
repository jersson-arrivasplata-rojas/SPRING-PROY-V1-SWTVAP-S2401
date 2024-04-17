package com.jersson.arrivasplata.swtvap.api.order.repository;
import com.jersson.arrivasplata.swtvap.api.common.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findAll();
    void deleteById(Long id);

    List<OrderDetail> findByOrderCode(String orderCode);
}
