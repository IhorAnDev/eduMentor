package com.enterprise.edumentorapi.service.lesson;

import com.enterprise.edumentorapi.entity.Lesson;
import com.enterprise.edumentorapi.payload.request.lesson.LessonRequest;

import java.util.List;

public interface LessonService {
    Lesson addLessonToCourse(Long courseId, LessonRequest lessonRequest);

    Lesson getLessonById(Long lessonId);

    List<Lesson> getLessonsByCourseId(Long courseId);
}
