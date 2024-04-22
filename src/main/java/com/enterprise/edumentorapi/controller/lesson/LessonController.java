package com.enterprise.edumentorapi.controller.lesson;

import com.enterprise.edumentorapi.entity.Lesson;
import com.enterprise.edumentorapi.payload.request.lesson.LessonRequest;
import com.enterprise.edumentorapi.payload.response.lesson.LessonEntityResponse;
import com.enterprise.edumentorapi.service.lesson.LessonService;
import com.enterprise.edumentorapi.utills.transfer_object.LessonResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
