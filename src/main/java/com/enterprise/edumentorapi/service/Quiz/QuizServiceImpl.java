package com.enterprise.edumentorapi.service.Quiz;

import com.enterprise.edumentorapi.entity.Lesson;
import com.enterprise.edumentorapi.entity.Question;
import com.enterprise.edumentorapi.entity.Quiz;
import com.enterprise.edumentorapi.payload.request.qiuz.AddQuestionRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.QuizRequest;
import com.enterprise.edumentorapi.repository.LessonRepository;
import com.enterprise.edumentorapi.repository.QuizQuestionRepository;
import com.enterprise.edumentorapi.repository.QuizRepository;
import com.enterprise.edumentorapi.service.lesson.LessonService;
import com.enterprise.edumentorapi.utills.transfer_object.entity_mapper.QuizMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final LessonService lessonService;
    private final QuizMapper quizMapper;
    private final LessonRepository lessonRepository;
    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizRepository quizRepository;

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
}
