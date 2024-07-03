package com.enterprise.edumentorapi.utills.transfer_object.entity_mapper;

import com.enterprise.edumentorapi.entity.*;
import com.enterprise.edumentorapi.payload.request.homework.AssigmentRequest;
import com.enterprise.edumentorapi.payload.request.homework.HWAnswerRequest;
import com.enterprise.edumentorapi.payload.request.homework.HWRequest;
import org.springframework.stereotype.Component;

@Component
public class HWEntityMapper {

    public HomeWork toHomeWorkEntity(Lesson lesson, HWRequest hwRequest) {
        HomeWork homeWork = new HomeWork();
        homeWork.setLesson(lesson);
        homeWork.setTitle(hwRequest.getTitle());
        homeWork.setDescription(hwRequest.getDescription());
        homeWork.setIsMandatory(hwRequest.isMandatory());
        homeWork.setAssignmentHw(toAssignmentHwEntity(hwRequest.getAssigmentRequest()));
        lesson.setHomeWork(homeWork);
        return homeWork;
    }

    public AssignmentHw toAssignmentHwEntity(AssigmentRequest assigmentRequest) {
        AssignmentHw assignmentHw = new AssignmentHw();
        assignmentHw.setAssignmentTask(assigmentRequest.getAssignmentTask());
        assignmentHw.setAssigmentUrl(assigmentRequest.getAssigmentUrl());
        return assignmentHw;
    }


    public HomeworkAnswer toHomeworkAnswerEntity(HWAnswerRequest request) {
        HomeworkAnswer homeworkAnswer = new HomeworkAnswer();
        homeworkAnswer.setAnswerUrl(request.getAnswerUrl());
        return homeworkAnswer;
    }
}
