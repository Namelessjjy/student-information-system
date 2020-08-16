package com.student.information.dto;

import lombok.Data;

@Data
public class GetStudentRequest {

    private String number;

    private String name;

    private String sex;

    private String classNum;

    private String phoneNum;
}
