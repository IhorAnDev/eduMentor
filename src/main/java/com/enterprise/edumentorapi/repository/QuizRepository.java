package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query("SELECT qz FROM Quiz qz" +
            " LEFT JOIN FETCH qz.questions qu " +
            "LEFT JOIN FETCH qu.answerOptions " +
            "WHERE qz.quizId = :quizId")
    Optional<Quiz> findByIdWithQuestions(@Param("quizId") Long quizId);
}
