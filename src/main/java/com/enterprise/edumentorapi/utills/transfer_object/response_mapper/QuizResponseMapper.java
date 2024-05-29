package com.enterprise.edumentorapi.utills.transfer_object.response_mapper;

import com.enterprise.edumentorapi.entity.AnswerOption;
import com.enterprise.edumentorapi.entity.Question;
import com.enterprise.edumentorapi.entity.QuizSubmission;
import com.enterprise.edumentorapi.payload.response.qiuz.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuizResponseMapper {

    public AnswerOptionResponse toAnswerOptionResponse(AnswerOption answerOption) {
        return new AnswerOptionResponse(answerOption.getOptionId(),
                answerOption.getText(), answerOption.getIsCorrect());
    }

    public QuizSubmissionResponse toQuizSubmissionResponse(QuizSubmission quizSubmission,
                                                           List<AnswerDetail> answerDetails,
                                                           QuizSubmissionDetails submissionDetails) {
        QuizSubmissionResponse response = new QuizSubmissionResponse();
        response.setId(quizSubmission.getId());
        response.setUserId(quizSubmission.getUser().getUserId());
        response.setQuizId(quizSubmission.getQuiz().getQuizId());
        response.setDetails(submissionDetails);
        response.setAnswers(answerDetails);
        return response;
    }

    public QuestionResponse toQuestionResponse(Question question) {
        QuestionResponse response = new QuestionResponse();
        response.setQuestionId(question.getQuestionId());
        response.setText(question.getText());
        response.setQuizId(question.getQuiz().getQuizId());
        response.setAnswerOptions(question.getAnswerOptions().stream()
                .map(this::toAnswerOptionResponse)
                .collect(Collectors.toList()));
        return response;
    }
}
