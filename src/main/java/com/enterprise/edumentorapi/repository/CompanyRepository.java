package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT c FROM Company c LEFT JOIN FETCH c.companyStudents WHERE c.companyId = :companyId")
    Optional<Company> findCompanyWithStudentsById(@Param("companyId") Long companyId);
}
