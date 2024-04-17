package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.model.WClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WClientRepository extends JpaRepository<WClient, Long> {
    WClient findByName(String name);
}
