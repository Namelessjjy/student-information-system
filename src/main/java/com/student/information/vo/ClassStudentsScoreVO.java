package com.student.information.vo;

import lombok.Data;

import java.util.List;

/**
 * 按班级返回学生成绩
 */
@Data
public class ClassStudentsScoreVO {

    private int classNum;

    private List<StudentCourseScoreVO> studentCourseScoreVOS;
}
