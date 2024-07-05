package com.enterprise.edumentorapi.service.homework;

import com.enterprise.edumentorapi.entity.HomeWork;
import com.enterprise.edumentorapi.entity.HomeWorkSubmission;
import com.enterprise.edumentorapi.payload.request.homework.HWRequest;
import com.enterprise.edumentorapi.payload.request.homework.HWSubmitRequest;
import com.enterprise.edumentorapi.payload.response.homework.AnswerToHWResponse;

import java.util.List;
import java.util.Optional;

public interface HWService {
    HomeWork createHW(Long lessonId, HWRequest hwRequest);

    HomeWorkSubmission submitHW(Long hwId, HWSubmitRequest hwSubmitRequest);

    HomeWork getHomeWorkById(Long hwId);

    List<AnswerToHWResponse> getCustomAnswersByLessonId(Long lessonId);
}
