package com.webtechlabs.gestionstock.repository;

import com.webtechlabs.gestionstock.enums.ERole;
import com.webtechlabs.gestionstock.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String>{
    Optional<Role> findByName(ERole name);
}
