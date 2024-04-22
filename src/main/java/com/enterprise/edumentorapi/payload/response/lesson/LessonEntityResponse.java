package com.enterprise.edumentorapi.payload.response.lesson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonEntityResponse {
    private Long lessonId;
    private String title;
    private String description;
    private Boolean isMandatory;
}
