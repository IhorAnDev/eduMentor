package com.enterprise.edumentorapi.controller.course;

import com.enterprise.edumentorapi.payload.request.course.CreateCourseRequest;
import com.enterprise.edumentorapi.service.course.CourseService;
import com.enterprise.edumentorapi.utills.transfer_object.CourseTransferObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course/v1")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CourseTransferObject courseTransferObject;
    @PostMapping("/create")
    public ResponseEntity<Void> createCourse(@RequestBody CreateCourseRequest request) {
        courseService.createCourseCompany(courseTransferObject.fromRequestCourse(request), request.getCompanyId());
        return ResponseEntity.ok().build();

    }
}
