package com.student.information.db.repository;

import com.student.information.db.entity.Score;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ScoreRepository {

    @Resource
    private ScoreJpaRepository scoreJpaRepository;

    public List<Score> getScoreByStudentNum(String number) {
        return scoreJpaRepository.findAllByStudentNum(number);
    }

    public Score getScoreByStudentNumAndCourseId(String number, int courseId) {
        return scoreJpaRepository.findByStudentNumAndCourseId(number, courseId);
    }

    public void addScore(Score newScore) {
        scoreJpaRepository.saveAndFlush(newScore);
    }
}
