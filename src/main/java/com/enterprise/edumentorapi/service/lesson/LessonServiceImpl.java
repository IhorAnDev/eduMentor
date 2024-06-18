package com.enterprise.edumentorapi.service.lesson;

import com.enterprise.edumentorapi.entity.Course;
import com.enterprise.edumentorapi.entity.Lesson;
import com.enterprise.edumentorapi.exceptions.EntityNotFoundException;
import com.enterprise.edumentorapi.payload.request.lesson.LessonRequest;
import com.enterprise.edumentorapi.repository.LessonRepository;
import com.enterprise.edumentorapi.service.course.CourseService;
import com.enterprise.edumentorapi.utills.transfer_object.entity_mapper.LessonMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final CourseService courseService;
    private final LessonMapper lessonMapper;

    @Override
    @Transactional
    public Lesson addLessonToCourse(Long courseId, LessonRequest lessonRequest) {
        Course course = courseService.getCourseById(courseId);
        Lesson lesson = lessonMapper.fromRequest(lessonRequest);
        lesson.setCourse(course);
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson getLessonById(Long lessonId) {
        return lessonRepository.findById(lessonId)
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found with id: " + lessonId));
    }
}
