package com.enterprise.edumentorapi.repository;

import com.enterprise.edumentorapi.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
