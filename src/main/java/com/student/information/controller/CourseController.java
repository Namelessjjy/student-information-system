package com.student.information.controller;

import com.student.information.dto.EditScoreRequest;
import com.student.information.dto.GetScoreRequest;
import com.student.information.service.CourseScoreService;
import com.student.information.util.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseScoreService courseScoreService;


    @GetMapping("/getscore")
    public Response getScore(GetScoreRequest getScoreRequest) {
        return courseScoreService.getScore(getScoreRequest.getNumber());
    }

    @PostMapping("/editscore")
    public Response editScore(@RequestBody EditScoreRequest editScoreRequest) {
        return courseScoreService.editScore(editScoreRequest.getNumber(), editScoreRequest.getCourseId(), editScoreRequest.getScore());
    }
}
