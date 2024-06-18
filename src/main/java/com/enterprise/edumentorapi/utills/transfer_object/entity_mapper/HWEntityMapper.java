package com.enterprise.edumentorapi.utills.transfer_object.entity_mapper;

import com.enterprise.edumentorapi.entity.AssignmentHw;
import com.enterprise.edumentorapi.entity.HomeWork;
import com.enterprise.edumentorapi.entity.Lesson;
import com.enterprise.edumentorapi.payload.request.homework.AssigmentRequest;
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
        return homeWork;
    }

    public AssignmentHw toAssignmentHwEntity(AssigmentRequest assigmentRequest) {
        AssignmentHw assignmentHw = new AssignmentHw();
        assignmentHw.setAssignmentTask(assigmentRequest.getAssignmentTask());
        assignmentHw.setAssigmentUrl(assigmentRequest.getAssigmentUrl());
        return assignmentHw;
    }
}
