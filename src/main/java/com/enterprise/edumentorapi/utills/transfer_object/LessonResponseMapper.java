package com.enterprise.edumentorapi.utills.transfer_object;

import com.enterprise.edumentorapi.entity.Lesson;
import com.enterprise.edumentorapi.payload.response.lesson.LessonEntityResponse;
import org.springframework.stereotype.Component;

@Component
public class LessonResponseMapper {
    public LessonEntityResponse toResponse(Lesson lesson) {
        LessonEntityResponse response = new LessonEntityResponse();
        response.setLessonId(lesson.getLessonId());
        response.setTitle(lesson.getTitle());
        response.setDescription(lesson.getDescription());
        response.setIsMandatory(lesson.getIsMandatory());
        return response;
    }
}
