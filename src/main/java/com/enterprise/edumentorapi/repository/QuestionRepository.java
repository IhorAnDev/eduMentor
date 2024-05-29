package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("SELECT q FROM Question q LEFT JOIN FETCH q.answerOptions WHERE q.questionId = :questionId")
    Optional<Question> findByIdWithAnswerOptions(@Param("questionId") Long questionId);
}
