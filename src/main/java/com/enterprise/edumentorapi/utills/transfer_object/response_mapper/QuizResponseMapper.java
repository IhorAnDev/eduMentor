package com.enterprise.edumentorapi.utills.transfer_object.response_mapper;

import com.enterprise.edumentorapi.entity.AnswerOption;
import com.enterprise.edumentorapi.entity.QuizSubmission;
import com.enterprise.edumentorapi.payload.response.qiuz.AnswerDetail;
import com.enterprise.edumentorapi.payload.response.qiuz.AnswerOptionResponse;
import com.enterprise.edumentorapi.payload.response.qiuz.QuizSubmissionDetails;
import com.enterprise.edumentorapi.payload.response.qiuz.QuizSubmissionResponse;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
