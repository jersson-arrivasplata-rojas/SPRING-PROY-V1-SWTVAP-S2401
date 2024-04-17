package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.model.WOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WOrderRepository extends JpaRepository<WOrder,Long> {

    WOrder findByCode(String code);
    @Query(value = "SELECT * FROM get_order_summary_fn()", nativeQuery = true)
    List<Object[]> getOrderSummary();
}
