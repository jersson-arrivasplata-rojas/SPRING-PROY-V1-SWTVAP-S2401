package com.jersson.arrivasplata.swtvap.api.order.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findByCode(String code);
    @Query(value = "SELECT * FROM get_order_summary_fn()", nativeQuery = true)
    List<Object[]> getOrderSummary();
}
