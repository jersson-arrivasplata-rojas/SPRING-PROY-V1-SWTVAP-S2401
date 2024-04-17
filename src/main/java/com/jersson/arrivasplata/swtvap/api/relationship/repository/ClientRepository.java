package com.jersson.arrivasplata.swtvap.api.relationship.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByName(String name);
}
