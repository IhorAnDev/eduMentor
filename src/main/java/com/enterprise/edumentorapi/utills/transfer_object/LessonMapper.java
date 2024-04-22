package com.enterprise.edumentorapi.utills.transfer_object;

import com.enterprise.edumentorapi.entity.Lesson;
import com.enterprise.edumentorapi.payload.request.lesson.LessonRequest;
import org.springframework.stereotype.Component;

@Component
public class LessonMapper {

    public Lesson fromRequest(LessonRequest request) {
        Lesson lesson = new Lesson();
        lesson.setTitle(request.getTitle());
        lesson.setDescription(request.getDescription());
        lesson.setIsMandatory(request.getIsMandatory());
        return lesson;
    }

}
