package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.Course;
import com.enterprise.edumentorapi.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> getLessonByCourse(Course course);
}
