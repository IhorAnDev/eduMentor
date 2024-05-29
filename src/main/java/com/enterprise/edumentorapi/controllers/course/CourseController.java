package com.enterprise.edumentorapi.controllers.course;

import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.request.course.AssignUsersCourseRequest;
import com.enterprise.edumentorapi.payload.request.course.CreateCourseRequest;
import com.enterprise.edumentorapi.service.company.CompanyService;
import com.enterprise.edumentorapi.service.course.CourseService;
import com.enterprise.edumentorapi.service.user.UserService;
import com.enterprise.edumentorapi.utills.transfer_object.CourseTransferObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/course/v1")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final UserService userService;
    private final CourseTransferObject courseTransferObject;

    @PostMapping("/create")
    public ResponseEntity<Void> createCourse(@RequestBody CreateCourseRequest request) {
        courseService.createCourseCompany(courseTransferObject.fromRequestCourse(request), request.getCompanyId());
        return ResponseEntity.ok().build();

    }

    @PostMapping("/assign")
    public ResponseEntity<Void> assignUsersToCourse(@RequestBody AssignUsersCourseRequest assignCourseRequest) {
        courseService.assignUsersToCourse(userService.getUsersByIds(assignCourseRequest.getUserIds()),
                courseService.getCourseById(assignCourseRequest.getCourseId()));
        return ResponseEntity.ok().build();
    }
}
