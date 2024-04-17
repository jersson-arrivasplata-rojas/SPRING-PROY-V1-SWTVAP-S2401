package com.jersson.arrivasplata.swtvap.api.relationship.repository;

import com.jersson.arrivasplata.swtvap.api.common.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Provider findByName(String name);
}
