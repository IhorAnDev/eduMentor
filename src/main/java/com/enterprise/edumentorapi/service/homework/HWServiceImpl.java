package com.enterprise.edumentorapi.service.homework;

import com.enterprise.edumentorapi.entity.HomeWork;
import com.enterprise.edumentorapi.entity.Lesson;
import com.enterprise.edumentorapi.payload.request.homework.HWRequest;
import com.enterprise.edumentorapi.payload.response.homework.HWResponse;
import com.enterprise.edumentorapi.repository.HWRepository;
import com.enterprise.edumentorapi.repository.LessonRepository;
import com.enterprise.edumentorapi.service.lesson.LessonService;
import com.enterprise.edumentorapi.utills.transfer_object.entity_mapper.HWEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HWServiceImpl implements HWService {

    private final HWRepository hwRepository;
    private final LessonService lessonService;
    private final HWEntityMapper hwEntityMapper;

    @Override
    public HomeWork createHW(Long lessonId, HWRequest hwRequest) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        HomeWork homeWork = hwEntityMapper.toHomeWorkEntity(lesson, hwRequest);
        return hwRepository.save(homeWork);
    }
}
