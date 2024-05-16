package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.QuizSubmission;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizSubmissionRepository extends JpaRepository<QuizSubmission, Long> {
    @Query("SELECT q FROM QuizSubmission q LEFT JOIN FETCH q.answers WHERE q.id = :id")
    QuizSubmission findByIdWithAnswers(@Param("id") Long id);

    @EntityGraph(attributePaths = {"user", "quiz", "answers"})
    Optional<QuizSubmission> findWithDetailsById(Long id);

    @Query("SELECT q FROM QuizSubmission q JOIN FETCH q.user u JOIN FETCH q.quiz quiz WHERE q.id = :id")
    Optional<QuizSubmission> findDetailedById(@Param("id") Long id);
}
