package com.enterprise.edumentorapi.utills.transfer_object.entity_mapper;

import com.enterprise.edumentorapi.entity.AnswerOption;
import com.enterprise.edumentorapi.entity.Question;
import com.enterprise.edumentorapi.entity.Quiz;
import com.enterprise.edumentorapi.payload.request.qiuz.AddQuestionRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.AnswerOptionRequest;
import com.enterprise.edumentorapi.payload.request.qiuz.QuizRequest;
import org.springframework.stereotype.Component;

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
}
