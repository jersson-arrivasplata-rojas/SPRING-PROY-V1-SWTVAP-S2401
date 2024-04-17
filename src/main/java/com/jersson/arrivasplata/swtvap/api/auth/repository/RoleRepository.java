package com.jersson.arrivasplata.swtvap.api.auth.repository;

import com.jersson.arrivasplata.swtvap.api.admin.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}