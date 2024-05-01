package com.enterprise.edumentorapi.utills.transfer_object.response_mapper;

import com.enterprise.edumentorapi.entity.AnswerOption;
import com.enterprise.edumentorapi.payload.response.qiuz.AnswerOptionResponse;
import org.springframework.stereotype.Component;

@Component
public class QuizResponseMapper {

    public AnswerOptionResponse toAnswerOptionResponse(AnswerOption answerOption) {
        return new AnswerOptionResponse(answerOption.getOptionId(),
                answerOption.getText(), answerOption.getIsCorrect());
    }
}
