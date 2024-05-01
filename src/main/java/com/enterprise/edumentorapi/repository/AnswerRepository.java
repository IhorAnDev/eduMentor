package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerOption, Long> {
}
