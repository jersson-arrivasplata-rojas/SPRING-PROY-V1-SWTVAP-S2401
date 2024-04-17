package com.jersson.arrivasplata.swtvap.api.logistic.repository;

import com.jersson.arrivasplata.swtvap.api.logistic.model.Dispatches;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DispatchesRepository extends JpaRepository<Dispatches,Long> {

    Optional<Dispatches> findById(Long id);
}
