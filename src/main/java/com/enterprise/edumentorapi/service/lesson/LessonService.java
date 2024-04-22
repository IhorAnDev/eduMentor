package com.enterprise.edumentorapi.service.lesson;

import com.enterprise.edumentorapi.entity.Lesson;
import com.enterprise.edumentorapi.payload.request.lesson.LessonRequest;

public interface LessonService {
    Lesson addLessonToCourse(Long courseId, LessonRequest lessonRequest);
}
