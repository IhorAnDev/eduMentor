package com.enterprise.edumentorapi.utills.transfer_object;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class HomeworkAnswerDTO {
    private Long lessonId;
    private String answerUrl;
    private Long homeworkAnswerId;
    private Long homeWorkId;
    private String assignmentUrl;
    private Long assignmentId;
    private Long userId;

    public HomeworkAnswerDTO(Long lessonId, Long homeworkAnswerId, String answerUrl, Long homeWorkId, String assignmentUrl, Long assignmentId, Long userId) {
        this.lessonId = lessonId;
        this.homeworkAnswerId = homeworkAnswerId;
        this.answerUrl = answerUrl;
        this.homeWorkId = homeWorkId;
        this.assignmentUrl = assignmentUrl;
        this.assignmentId = assignmentId;
        this.userId = userId;
    }
}
