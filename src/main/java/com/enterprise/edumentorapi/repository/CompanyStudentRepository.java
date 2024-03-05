package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.CompanyStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyStudentRepository extends JpaRepository<CompanyStudent, Long> {
}
