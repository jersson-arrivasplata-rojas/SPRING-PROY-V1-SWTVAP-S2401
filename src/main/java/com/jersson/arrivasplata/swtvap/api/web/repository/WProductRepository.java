package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import com.jersson.arrivasplata.swtvap.api.web.model.WProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WProductRepository extends JpaRepository<WProduct,Long> {

    //@Query("SELECT p FROM Product p JOIN FETCH p.productImages JOIN FETCH p.units WHERE p.name = :name AND p.status = :status AND p.deletedAt IS NULL")
    WProduct findByNameAndStatusAndDeletedAtIsNull(String name, Status status);

    WProduct findByNameEnAndStatusAndDeletedAtIsNull(String name, Status status);
}
