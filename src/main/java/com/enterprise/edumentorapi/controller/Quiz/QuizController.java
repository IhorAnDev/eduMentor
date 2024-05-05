package com.enterprise.edumentorapi.controller.Quiz;

import com.enterprise.edumentorapi.entity.QuizSubmission;
import com.enterprise.edumentorapi.payload.request.qiuz.AddQuestionRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.AnswerOptionRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.QuizRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.QuizSubmissionRequest;
import com.enterprise.edumentorapi.payload.response.qiuz.AnswerDetail;
import com.enterprise.edumentorapi.payload.response.qiuz.AnswerOptionResponse;
import com.enterprise.edumentorapi.payload.response.qiuz.QuizSubmissionDetails;
import com.enterprise.edumentorapi.payload.response.qiuz.QuizSubmissionResponse;
import com.enterprise.edumentorapi.service.quiz.QuizService;
import com.enterprise.edumentorapi.utills.transfer_object.response_mapper.QuizResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/quiz/v1")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
    private final QuizResponseMapper quizResponseMapper;

    @PostMapping("/lesson/{lessonId}/create")
    public ResponseEntity<?> createQuiz(@PathVariable Long lessonId, @RequestBody QuizRequest quizRequest) {
        quizService.createQuiz(quizRequest, lessonId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/question/{quizId}/create")
    public ResponseEntity<?> createQuestion(@PathVariable Long quizId, @RequestBody AddQuestionRequest questionRequest) {
        quizService.createQuestion(quizId, questionRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/question/{questionId}/options")
    public ResponseEntity<?> addAnswerOptions(@PathVariable Long questionId, @RequestBody List<AnswerOptionRequest> requests) {
        try {
            List<AnswerOptionResponse> answerOptionsResponse = quizService.addAnswerOptions(questionId, requests);
            return ResponseEntity.ok(answerOptionsResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error adding answer options: " + e.getMessage());
        }
    }

    @PostMapping("/submit/{quizId}")
    public ResponseEntity<?> submitQuiz(@PathVariable Long quizId, @RequestBody QuizSubmissionRequest submissionRequest) {
        try {
            QuizSubmission quizSubmission = quizService.submitQuiz(quizId, submissionRequest);
            List<AnswerDetail> answerDetails = quizService.getAnswerDetails(quizSubmission.getId());
            QuizSubmissionDetails submissionDetails = new QuizSubmissionDetails();
            QuizSubmissionResponse response = quizResponseMapper
                    .toQuizSubmissionResponse(quizSubmission, answerDetails, submissionDetails);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error submitting quiz: " + e.getMessage());
        }
    }
}
