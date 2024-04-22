package com.enterprise.edumentorapi.payload.request.lesson;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LessonRequest {
    private String title;
    private String description;
    private Boolean isMandatory;
}
