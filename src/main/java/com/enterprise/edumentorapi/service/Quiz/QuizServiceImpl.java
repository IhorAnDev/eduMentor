package com.enterprise.edumentorapi.service.Quiz;

import com.enterprise.edumentorapi.entity.AnswerOption;
import com.enterprise.edumentorapi.entity.Lesson;
import com.enterprise.edumentorapi.entity.Question;
import com.enterprise.edumentorapi.entity.Quiz;
import com.enterprise.edumentorapi.payload.request.qiuz.AddQuestionRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.AnswerOptionRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.QuizRequest;
import com.enterprise.edumentorapi.payload.response.qiuz.AnswerOptionResponse;
import com.enterprise.edumentorapi.repository.*;
import com.enterprise.edumentorapi.service.lesson.LessonService;
import com.enterprise.edumentorapi.utills.transfer_object.entity_mapper.QuizMapper;
import com.enterprise.edumentorapi.utills.transfer_object.response_mapper.QuizResponseMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
