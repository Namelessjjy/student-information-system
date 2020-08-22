package com.student.information;

import com.student.information.db.repository.ScoreJpaRepository;
import com.student.information.db.repository.ScoreRepository;
import com.student.information.db.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class InformationApplicationTests {

    @Resource
    private ScoreJpaRepository scoreJpaRepository;

    @Resource
    private StudentRepository studentRepository;

    @Test
    void contextLoads() {
        List<Integer> list = studentRepository.getAllClass();
    }

    @Test
    void test() {
        scoreJpaRepository.findAllByStudentNum("2017141001");
    }

}
