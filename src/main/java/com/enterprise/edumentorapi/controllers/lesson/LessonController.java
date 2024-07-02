package com.enterprise.edumentorapi.controllers.lesson;

import com.enterprise.edumentorapi.entity.Lesson;
import com.enterprise.edumentorapi.payload.request.lesson.LessonRequest;
import com.enterprise.edumentorapi.payload.response.lesson.LessonEntityResponse;
import com.enterprise.edumentorapi.service.lesson.LessonService;
import com.enterprise.edumentorapi.utills.transfer_object.response_mapper.LessonResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons/v1")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;
    private final LessonResponseMapper lessonResponseMapper;

    @PostMapping("/courses/{courseId}/add")
    public ResponseEntity<LessonEntityResponse> addLessonToCourse(@PathVariable Long courseId,
                                                                  @RequestBody LessonRequest lessonRequest) {
        Lesson lesson = lessonService.addLessonToCourse(courseId, lessonRequest);
        return ResponseEntity.ok(lessonResponseMapper.toResponse(lesson));
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<List<LessonEntityResponse>> getLessonsByCourseId(@PathVariable Long courseId) {
        List<Lesson> lessons = lessonService.getLessonsByCourseId(courseId);
        return ResponseEntity.ok(lessons.stream().map(lessonResponseMapper::toResponse).toList());
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<LessonEntityResponse> getLessonById(@PathVariable Long lessonId) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        return ResponseEntity.ok(lessonResponseMapper.toResponse(lesson));
    }
}