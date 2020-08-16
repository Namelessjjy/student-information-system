package com.student.information.dto;

import lombok.Data;

@Data
public class UpdateStudentRequest {

    private String number;

    private String name;

    private String sex;

    private int classNum;

    private String birthday;

    private String phoneNum;

    private String address;

}
