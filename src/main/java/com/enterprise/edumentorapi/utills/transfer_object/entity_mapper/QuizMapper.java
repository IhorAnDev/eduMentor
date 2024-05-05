package com.enterprise.edumentorapi.utills.transfer_object.entity_mapper;

import com.enterprise.edumentorapi.entity.*;
import com.enterprise.edumentorapi.payload.request.qiuz.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class QuizMapper {
    public Quiz toQuizEntity(QuizRequest quizRequest) {
        Quiz quiz = new Quiz();
        quiz.setName(quizRequest.getName());
        return quiz;
    }

    public Question toQuestionEntity(Quiz quiz, AddQuestionRequest questionRequest) {
        Question question = new Question();
        question.setText(questionRequest.getText());
        question.setQuiz(quiz);
        return question;
    }

    public AnswerOption toAnswerOptionEntity(Question question, AnswerOptionRequest answerOptionRequest) {
        AnswerOption answerOption = new AnswerOption();
        answerOption.setText(answerOptionRequest.getText());
        answerOption.setIsCorrect(answerOptionRequest.isCorrect());
        answerOption.setQuestion(question);
        return answerOption;
    }

    public QuizSubmission toQuizSubmissionEntity(Quiz quiz, Set<Answer> answers, User user) {
        QuizSubmission quizSubmission = new QuizSubmission();
        quizSubmission.setQuiz(quiz);
        quizSubmission.setUser(user);
        quizSubmission.setCompletedAt(LocalDateTime.now());
        quizSubmission.setAnswers(answers);
        return quizSubmission;
    }

    public Answer toAnswerEntity(Question question, AnswerOption answerOption, QuizSubmission quizSubmission) {
        Answer answer = new Answer();
        answer.setChosenOption(answerOption);
        answer.setQuestion(question);
        answer.setSubmission(quizSubmission);
        return answer;
    }
}
