package com.webtechlabs.gestionstock.repository;

import com.webtechlabs.gestionstock.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
