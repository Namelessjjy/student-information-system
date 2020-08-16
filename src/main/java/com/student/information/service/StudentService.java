package com.student.information.service;

import com.student.information.dto.AddStudentRequest;
import com.student.information.dto.DeleteStudentRequest;
import com.student.information.dto.GetStudentRequest;
import com.student.information.dto.UpdateStudentRequest;
import com.student.information.util.Response;
import com.student.information.vo.StudentInformationVO;

public interface StudentService {

    /**
     * 获取学生信息
     * @param getStudentRequest 获取学生的参数，若参数为空则返回所有学生
     * @return
     */
    Response<StudentInformationVO> getStudents(GetStudentRequest getStudentRequest);

    /**
     * 添加学生
     * @param addStudentRequest
     * @return
     */
    Response addStudent(AddStudentRequest addStudentRequest);

    /**
     * 删除学生
     * @param deleteStudentRequest
     * @return
     */
    Response deleteStudent(DeleteStudentRequest deleteStudentRequest);

    /**
     * 更新学生信息
     * @param updateStudentRequest
     * @return
     */
    Response updateStudent(UpdateStudentRequest updateStudentRequest);
}
