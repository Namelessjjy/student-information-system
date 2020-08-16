package com.student.information.controller;

import com.student.information.dto.AddStudentRequest;
import com.student.information.dto.DeleteStudentRequest;
import com.student.information.dto.GetStudentRequest;
import com.student.information.dto.UpdateStudentRequest;
import com.student.information.service.StudentService;
import com.student.information.util.Response;
import com.student.information.vo.StudentInformationVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController()
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/getstudents")
    public Response<StudentInformationVO> getStudent(GetStudentRequest getStudentRequest) {
        return studentService.getStudents(getStudentRequest);
    }

    @PostMapping("/addstudent")
    public Response addStudent(@RequestBody AddStudentRequest addStudentRequest) {
        return studentService.addStudent(addStudentRequest);
    }

    @PostMapping("/updatestudent")
    public Response addStudent(@RequestBody UpdateStudentRequest updateStudentRequest) {
        return studentService.updateStudent(updateStudentRequest);
    }

    @DeleteMapping("/deletestudent")
    public Response deleteStudent(@RequestBody DeleteStudentRequest deleteStudentRequest) {
        return studentService.deleteStudent(deleteStudentRequest);
    }

}
