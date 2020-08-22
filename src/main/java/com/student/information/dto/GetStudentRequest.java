package com.student.information.dto;

import lombok.Data;

@Data
public class GetStudentRequest {

    private String number;

    private String name;

    private String sex;

    private int classNum;

    private String phoneNum;
}
