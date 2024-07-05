package com.enterprise.edumentorapi.service.homework;

import com.enterprise.edumentorapi.entity.*;
import com.enterprise.edumentorapi.exceptions.EntityNotFoundException;
import com.enterprise.edumentorapi.payload.request.homework.HWRequest;
import com.enterprise.edumentorapi.payload.request.homework.HWSubmitRequest;
import com.enterprise.edumentorapi.payload.response.homework.AnswerToHWResponse;
import com.enterprise.edumentorapi.repository.HWRepository;
import com.enterprise.edumentorapi.repository.HWSubmissionRepository;
import com.enterprise.edumentorapi.repository.LessonRepository;
import com.enterprise.edumentorapi.service.lesson.LessonService;
import com.enterprise.edumentorapi.utills.SecurityUtils;
import com.enterprise.edumentorapi.utills.transfer_object.HomeworkAnswerDTO;
import com.enterprise.edumentorapi.utills.transfer_object.entity_mapper.HWEntityMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HWServiceImpl implements HWService {

    private final HWRepository hwRepository;
    private final LessonService lessonService;
    private final HWEntityMapper hwEntityMapper;
    private final LessonRepository lessonRepository;
    private final HWSubmissionRepository hwSubmissionRepository;


    @Override
    public HomeWork createHW(Long lessonId, HWRequest hwRequest) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        HomeWork homeWork = hwEntityMapper.toHomeWorkEntity(lesson, hwRequest);
        hwRepository.save(homeWork);
        lessonRepository.save(lesson);
        return homeWork;
    }


    @Override
    @Transactional
    public HomeWorkSubmission submitHW(Long hwId, HWSubmitRequest hwSubmitRequest) {
        HomeWork hw = getHomeWorkById(hwId);
        HomeworkAnswer homeworkAnswer = hwEntityMapper.toHomeworkAnswerEntity(hwSubmitRequest.getHomeworkAnswerRequest());
        User user = SecurityUtils.getCurrentUser();
        HomeWorkSubmission hwSubmission = new HomeWorkSubmission();
        hwSubmission.setHomeWork(hw);
        hwSubmission.setCompletedAt(LocalDateTime.now());
        hwSubmission.setUser(user);
        hwSubmission.setHomeworkAnswer(homeworkAnswer);
        homeworkAnswer.setHomeWorkSubmission(hwSubmission);
        return hwSubmissionRepository.save(hwSubmission);
    }

    @Override
    public HomeWork getHomeWorkById(Long hwId) {
        return hwRepository.findById(hwId).orElseThrow(() -> new EntityNotFoundException("HomeWork not found with id: " + hwId));
    }

    public List<AnswerToHWResponse> getCustomAnswersByLessonId(Long lessonId) {
        List<HomeworkAnswerDTO> homeworkAnswerDTOS = hwSubmissionRepository.findCustomAnswersByLessonId(lessonId);
        return homeworkAnswerDTOS.stream()
                .map(hwAnswerDTO -> new AnswerToHWResponse(hwAnswerDTO.getHomeWorkId(), hwAnswerDTO.getUserId(),
                        hwAnswerDTO.getHomeworkAnswerId(), hwAnswerDTO.getAnswerUrl())).toList();
    }
}
