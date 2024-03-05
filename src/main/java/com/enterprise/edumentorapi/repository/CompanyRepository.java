package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
