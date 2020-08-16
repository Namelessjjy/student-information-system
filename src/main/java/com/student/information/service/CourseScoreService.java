package com.student.information.service;


import com.student.information.dto.GetScoreRequest;
import com.student.information.util.Response;

public interface CourseScoreService {

    Response getScore(String number);

    Response editScore(String number, int courseId, int score);
}
