package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.model.WParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WParameterRepository extends JpaRepository<WParameter,Long> {
    List<WParameter> findByCode(String code);

    List<WParameter> findByParentId(Long parentId);

}
