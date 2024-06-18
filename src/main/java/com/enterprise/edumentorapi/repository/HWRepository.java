package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HWRepository extends JpaRepository<HomeWork, Long> {
}
