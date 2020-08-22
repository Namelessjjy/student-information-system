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
import javax.servlet.http.HttpServletResponse;

@RestController()
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/getstudents")
    public Response<StudentInformationVO> getStudent(GetStudentRequest getStudentRequest) {
        return studentService.getStudents(getStudentRequest);
    }

    @PostMapping("/addstudent")
    public Response addStudent(@RequestBody AddStudentRequest addStudentRequest, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST");
        return studentService.addStudent(addStudentRequest);
    }

    @PostMapping("/updatestudent")
    public Response addStudent(@RequestBody UpdateStudentRequest updateStudentRequest, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST");
        return studentService.updateStudent(updateStudentRequest);
    }

    @DeleteMapping("/deletestudent")
    public Response deleteStudent(@RequestBody DeleteStudentRequest deleteStudentRequest, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "DELETE");
        return studentService.deleteStudent(deleteStudentRequest);
    }

}
