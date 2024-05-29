package com.enterprise.edumentorapi.service.quiz;

import com.enterprise.edumentorapi.entity.AnswerOption;
import com.enterprise.edumentorapi.entity.Question;
import com.enterprise.edumentorapi.entity.Quiz;
import com.enterprise.edumentorapi.entity.QuizSubmission;
import com.enterprise.edumentorapi.payload.request.qiuz.AddQuestionRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.AnswerOptionRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.QuizRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.QuizSubmissionRequest;
import com.enterprise.edumentorapi.payload.response.qiuz.AnswerDetail;
import com.enterprise.edumentorapi.payload.response.qiuz.AnswerOptionResponse;

import java.util.List;

public interface QuizService {
    void createQuiz(QuizRequest quizRequest, Long lessonId);

    Quiz getQuizById(Long quizId);

    void createQuestion(Long quizId, AddQuestionRequest questionRequest);

    List<AnswerOptionResponse> addAnswerOptions(Long questionId, List<AnswerOptionRequest> requests);

    Question getQuestionById(Long questionId);

    Question getQuestionWithAnswerOptionsById(Long questionId);


    QuizSubmission submitQuiz(Long quizId, QuizSubmissionRequest submissionRequest);

    AnswerOption getAnswerOptionById(Long answerOptionId);

    List<AnswerDetail> getAnswerDetails(Long quizSubmissionId);

    List<Question> getQuestionsByQuizId(Long quizId);
}
