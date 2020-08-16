package com.student.information;

import com.student.information.db.repository.ScoreJpaRepository;
import com.student.information.db.repository.ScoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class InformationApplicationTests {

    @Resource
    private ScoreJpaRepository scoreJpaRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        scoreJpaRepository.findAllByStudentNum("2017141001");
    }

}
