package com.enterprise.edumentorapi.service.Quiz;

import com.enterprise.edumentorapi.entity.Quiz;
import com.enterprise.edumentorapi.payload.request.qiuz.AddQuestionRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.QuizRequest;

public interface QuizService {
    void createQuiz(QuizRequest quizRequest, Long lessonId);

    Quiz getQuizById(Long quizId);

    void createQuestion(Long quizId, AddQuestionRequest questionRequest);

}
