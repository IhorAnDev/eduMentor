package com.enterprise.edumentorapi.service.quiz;

import com.enterprise.edumentorapi.entity.*;
import com.enterprise.edumentorapi.payload.request.qiuz.AddQuestionRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.AnswerOptionRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.QuizRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.QuizSubmissionRequest;
import com.enterprise.edumentorapi.payload.response.qiuz.AnswerDetail;
import com.enterprise.edumentorapi.payload.response.qiuz.AnswerOptionResponse;
import com.enterprise.edumentorapi.repository.*;
import com.enterprise.edumentorapi.security.PersonDetails;
import com.enterprise.edumentorapi.service.lesson.LessonService;
import com.enterprise.edumentorapi.utills.transfer_object.entity_mapper.QuizMapper;
import com.enterprise.edumentorapi.utills.transfer_object.response_mapper.QuizResponseMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final LessonService lessonService;
    private final QuizMapper quizMapper;
    private final QuizResponseMapper quizResponseMapper;
    private final LessonRepository lessonRepository;
    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final AnswerOptionRepository answerOptionRepository;
    private final QuizSubmissionRepository quizSubmissionRepository;
    private final AnswerRepository answerRepository;

    @Override
    public void createQuiz(QuizRequest quizRequest, Long lessonId) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        lesson.setQuiz(quizMapper.toQuizEntity(quizRequest));
        lessonRepository.save(lesson);
    }

    @Override
    public Quiz getQuizById(Long quizId) {
        return quizRepository.findById(quizId)
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found with id: " + quizId));
    }


    @Override
    public void createQuestion(Long quizId, AddQuestionRequest questionRequest) {
        Quiz quiz = getQuizById(quizId);
        Question question = quizMapper.toQuestionEntity(quiz, questionRequest);
        quizQuestionRepository.save(question);
    }


    @Override
    public List<AnswerOptionResponse> addAnswerOptions(Long questionId, List<AnswerOptionRequest> requests) {
        List<AnswerOption> answerOptions = requests.stream()
                .map(request -> quizMapper.toAnswerOptionEntity(getQuestionById(questionId), request)).toList();
        return answerOptionRepository.saveAll(answerOptions).stream()
                .map(quizResponseMapper::toAnswerOptionResponse).toList();
    }

    @Override
    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + questionId));
    }


    @Override
    @Transactional
    public QuizSubmission submitQuiz(Long quizId, QuizSubmissionRequest submissionRequest) {
        Quiz quiz = getQuizById(quizId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = ((PersonDetails) authentication.getPrincipal()).getUser();

        QuizSubmission quizSubmission = new QuizSubmission();
        quizSubmission.setUser(user);
        quizSubmission.setQuiz(quiz);
        quizSubmission.setCompletedAt(LocalDateTime.now());
        quizSubmission.setAnswers(new HashSet<>());

        Set<Answer> answers = submissionRequest.getAnswerRequests().stream()
                .map(answerRequest -> {
                    Question question = getQuestionById(answerRequest.getQuestionId());
                    AnswerOption answerOption = getAnswerOptionById(answerRequest.getChosenOptionId());
                    return quizMapper.toAnswerEntity(question, answerOption, quizSubmission);
                }).collect(Collectors.toSet());
        quizSubmission.setAnswers(answers);
        return quizSubmissionRepository.save(quizSubmission);
    }

    @Override
    public AnswerOption getAnswerOptionById(Long answerOptionId) {
        return answerOptionRepository.findById(answerOptionId)
                .orElseThrow(() -> new EntityNotFoundException("Answer option not found with id: " + answerOptionId));
    }

    @Override
    public List<AnswerDetail> getAnswerDetails(Long quizSubmissionId) {
        QuizSubmission submission = quizSubmissionRepository.findById(quizSubmissionId)
                .orElseThrow(() -> new EntityNotFoundException("Quiz submission not found"));

        List<AnswerDetail> details = new ArrayList<>();
        for (Answer answer : submission.getAnswers()) {
            AnswerDetail detail = new AnswerDetail();
            detail.setQuestionId(answer.getQuestion().getQuestionId());
            detail.setChosenOptionId(answer.getChosenOption().getOptionId());
            detail.setCorrect(answer.getChosenOption().getIsCorrect());

            // Optionally, add an explanation
            detail.setExplanation(getExplanationForAnswer(answer));

            details.add(detail);
        }
        return details;
    }

    private String getExplanationForAnswer(Answer answer) {
        // This could be static text, pulled from a database, or even calculated
        if (answer.getChosenOption().getIsCorrect()) {
            return "Correct answer!";
        } else {
            return "Incorrect answer. Please review chapter X for more details.";
        }
    }
}
