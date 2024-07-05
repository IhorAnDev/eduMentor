package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.HomeWorkSubmission;
import com.enterprise.edumentorapi.utills.transfer_object.HomeworkAnswerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HWSubmissionRepository extends JpaRepository<HomeWorkSubmission, Long> {

    @Query("SELECT new com.enterprise.edumentorapi.utills.transfer_object.HomeworkAnswerDTO(" +
            "l.lessonId, hwans.homeworkAnswerId, hwans.answerUrl, " +
            "hw.homeWorkId, assign.assigmentUrl, assign.assignmentId, hs.user.userId) " +
            "FROM HomeWorkSubmission hs " +
            "JOIN hs.homeWork hw " +
            "JOIN hw.lesson l " +
            "JOIN hs.homeworkAnswer hwans " +
            "JOIN hw.assignmentHw assign " +
            "WHERE l.lessonId = :lessonId")
    List<HomeworkAnswerDTO> findCustomAnswersByLessonId(@Param("lessonId") Long lessonId);

}
