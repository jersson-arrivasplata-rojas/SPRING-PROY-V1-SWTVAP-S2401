package com.jersson.arrivasplata.swtvap.api.web.repository;
import com.jersson.arrivasplata.swtvap.api.web.model.WOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WOrderDetailRepository extends JpaRepository<WOrderDetail, Long> {
    List<WOrderDetail> findAll();
    void deleteById(Long id);

    List<WOrderDetail> findByOrderCode(String orderCode);
}
