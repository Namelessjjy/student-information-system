package com.student.information.controller;

import com.student.information.dto.EditScoreRequest;
import com.student.information.dto.GetScoreByClassRequest;
import com.student.information.dto.GetScoreRequest;
import com.student.information.service.CourseScoreService;
import com.student.information.util.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseScoreService courseScoreService;


    @GetMapping("/getscore")
    public Response getScore(GetScoreRequest getScoreRequest) {
        return courseScoreService.getScore(getScoreRequest.getNumber());
    }

    @GetMapping("/getscorebyclass")
    public Response getScoreByClass(GetScoreByClassRequest getScoreRequest) {
        return courseScoreService.getScoreByClass(getScoreRequest.getClassNum());
    }

    @PostMapping("/editscore")
    public Response editScore(@RequestBody EditScoreRequest editScoreRequest) {
        return courseScoreService.editScore(editScoreRequest.getNumber(), editScoreRequest.getCourseId(), editScoreRequest.getScore());
    }

    @GetMapping("/getscorewithclass")
    public Response getScoreWithClass() {
        return courseScoreService.getScoreWithClass();
    }
}
