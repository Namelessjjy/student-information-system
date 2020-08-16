package com.student.information.dto;


import lombok.Data;

@Data
public class EditScoreRequest {

    private String number;

    private int courseId;

    private int score;
}
