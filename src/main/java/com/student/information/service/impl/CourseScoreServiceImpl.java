package com.student.information.service.impl;

import com.student.information.db.entity.Score;
import com.student.information.db.entity.Student;
import com.student.information.db.repository.CourseRepository;
import com.student.information.db.repository.ScoreRepository;
import com.student.information.db.repository.StudentRepository;
import com.student.information.dto.GetStudentRequest;
import com.student.information.service.CourseScoreService;
import com.student.information.util.Response;
import com.student.information.util.ResponseStatusEnum;
import com.student.information.vo.CourseInformationVO;
import com.student.information.vo.StudentCourseScoreVO;
import com.student.information.vo.StudentInformationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseScoreServiceImpl implements CourseScoreService {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private ScoreRepository scoreRepository;

    @Resource
    private CourseRepository courseRepository;

    @Override
    public Response getScore(String number) {

        List<StudentCourseScoreVO> studentCourseScoreVOs = new ArrayList<>();

        // 如果为空则返回所有学生的成绩信息
        if (StringUtils.isEmpty(number)) {
            List<Student> students = studentRepository.getAllStudent();
            for (Student student : students) {
                getCourseScore(studentCourseScoreVOs, student);
            }
            return Response.valueOf(10000, "查询成功", studentCourseScoreVOs);
        }

        Student student = studentRepository.getStudentByNumber(number);
        if (student == null) {
            return Response.valueOf(ResponseStatusEnum.GET_STUDENT_FAILED);
        }

        getCourseScore(studentCourseScoreVOs, student);
        return Response.valueOf(10000, "查询成功", studentCourseScoreVOs);
    }

    /**
     * 用于组建成绩与课程名的关系并加入list中
     * @param studentCourseScoreVOs
     * @param student
     */
    private void getCourseScore(List<StudentCourseScoreVO> studentCourseScoreVOs, Student student) {
        StudentCourseScoreVO studentCourseScoreVO = new StudentCourseScoreVO();
        StudentInformationVO studentInformationVO = new StudentInformationVO();
        BeanUtils.copyProperties(student, studentInformationVO);
        studentCourseScoreVO.setStudentInformationVO(studentInformationVO);

        List<Score> scores = scoreRepository.getScoreByStudentNum(student.getNumber());
        List<CourseInformationVO> courseInformationVOs = new ArrayList<>();
        for (Score score : scores) {
            CourseInformationVO courseInformationVO = new CourseInformationVO();
            courseInformationVO.setCourseId(score.getCourseId());
            courseInformationVO.setScore(score.getScore());
            courseInformationVO.setCourseName(courseRepository.getCourseByCourseId(score.getCourseId()).getCourseName());
            courseInformationVOs.add(courseInformationVO);
        }
        studentCourseScoreVO.setCourseInformationVOs(courseInformationVOs);
        studentCourseScoreVOs.add(studentCourseScoreVO);
    }

    @Override
    public Response editScore(String number, int courseId, int score) {
        Score score1 = scoreRepository.getScoreByStudentNumAndCourseId(number, courseId);
        if (score1 == null) {
            Score newScore = new Score();
            newScore.setCourseId(courseId);
            newScore.setStudentNum(number);
            newScore.setScore(score);
            scoreRepository.addScore(newScore);
            return Response.valueOf(10000, "修改成功");
        }
        score1.setScore(score);
        scoreRepository.addScore(score1);
        return Response.valueOf(10000, "修改成功");
    }

    @Override
    public Response getScoreByClass(int classNum) {
        List<StudentCourseScoreVO> studentCourseScoreVOs = new ArrayList<>();

        // 如果为空则返回所有学生的成绩信息
        if (classNum > 0) {
            GetStudentRequest getStudentRequest = new GetStudentRequest();
            getStudentRequest.setClassNum(classNum);
            List<Student> students = studentRepository.getStudentList(getStudentRequest);
            for (Student student : students) {
                getCourseScore(studentCourseScoreVOs, student);
            }
            return Response.valueOf(10000, "查询成功", studentCourseScoreVOs);
        }

        return Response.valueOf(10001, "查询失败");
    }
}
