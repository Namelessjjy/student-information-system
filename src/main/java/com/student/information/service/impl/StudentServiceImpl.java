package com.student.information.service.impl;


import com.student.information.db.entity.Student;
import com.student.information.db.repository.StudentRepository;
import com.student.information.dto.AddStudentRequest;
import com.student.information.dto.DeleteStudentRequest;
import com.student.information.dto.GetStudentRequest;
import com.student.information.dto.UpdateStudentRequest;
import com.student.information.service.StudentService;
import com.student.information.util.Response;
import com.student.information.util.ResponseStatusEnum;
import com.student.information.vo.StudentInformationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Override
    public Response getStudents(GetStudentRequest getStudentRequest) {
        // 获取查询结果
        List<Student> students = studentRepository.getStudentList(getStudentRequest);
        // 若查询结果为空
        if (students == null || students.size() == 0) {
            return Response.valueOf(ResponseStatusEnum.GET_STUDENT_FAILED);
        }
        // 不为空则将查询结果封装成Response返回
        List<StudentInformationVO> studentInformationVOS = studentRepository.getStudentList(getStudentRequest).stream().map(student -> {
            StudentInformationVO studentInformationVO = new StudentInformationVO();
            studentInformationVO.setId(student.getId());
            studentInformationVO.setNumber(student.getNumber());
            studentInformationVO.setName(student.getName());
            studentInformationVO.setAddress(student.getAddress());
            studentInformationVO.setBirthday(student.getBirthday());
            studentInformationVO.setClassNum(student.getClassNum());
            studentInformationVO.setSex(student.getSex());
            studentInformationVO.setPhoneNum(student.getPhoneNum());
            return studentInformationVO;
        }).collect(Collectors.toList());
        return Response.valueOf(ResponseStatusEnum.GET_STUDENT_SUCCESS, studentInformationVOS);
    }

    @Override
    public Response addStudent(AddStudentRequest addStudentRequest) {
        Student student = new Student();
        BeanUtils.copyProperties(addStudentRequest, student);
        return studentRepository.addStudent(student);
    }

    @Override
    @Transactional
    public Response deleteStudent(DeleteStudentRequest deleteStudentRequest) {
        return studentRepository.deleteStudent(deleteStudentRequest.getNumber());
    }

    @Override
    public Response updateStudent(UpdateStudentRequest updateStudentRequest) {
        return studentRepository.updateStudent(updateStudentRequest);
    }
}
