package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.HomeWorkSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HWSubmissionRepository extends JpaRepository<HomeWorkSubmission, Long> {
}
