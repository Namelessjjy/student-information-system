package com.student.information.vo;

import lombok.Data;

import java.util.List;

@Data
public class StudentCourseScoreVO {

    private StudentInformationVO studentInformationVO;

    private List<CourseInformationVO> courseInformationVOs;

}
