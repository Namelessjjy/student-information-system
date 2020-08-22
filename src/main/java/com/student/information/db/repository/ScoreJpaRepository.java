package com.student.information.db.repository;

import com.student.information.db.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ScoreJpaRepository extends JpaRepository<Score, Long> {

    List<Score> findAllByStudentNum(String number);

    Score findByStudentNumAndCourseId(String string, int courseId);


}
