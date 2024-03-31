package com.enterprise.edumentorapi.payload.request.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AssignUsersCourseRequest {

    private Long courseId;
    private List<Long> userIds;
}
