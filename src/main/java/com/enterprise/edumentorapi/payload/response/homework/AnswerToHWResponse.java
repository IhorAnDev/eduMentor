package com.enterprise.edumentorapi.payload.response.homework;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerToHWResponse {
    private Long homeworkId;
    private Long studentId;
    private Long answerId;
    private String answerUrl;
}
