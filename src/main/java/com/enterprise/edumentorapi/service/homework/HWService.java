package com.enterprise.edumentorapi.service.homework;

import com.enterprise.edumentorapi.entity.HomeWork;
import com.enterprise.edumentorapi.payload.request.homework.HWRequest;
import com.enterprise.edumentorapi.payload.response.homework.HWResponse;

public interface HWService {
    HomeWork createHW(Long lessonId, HWRequest hwRequest);
}
