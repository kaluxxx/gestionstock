package com.webtechlabs.gestionstock.repository;

import com.webtechlabs.gestionstock.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findBySiret(String siret);
}
