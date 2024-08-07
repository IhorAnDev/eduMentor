package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizQuestionRepository extends JpaRepository<Question, Long> {
}
