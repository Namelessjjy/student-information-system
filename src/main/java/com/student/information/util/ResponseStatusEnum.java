package com.student.information.util;

public enum ResponseStatusEnum {

    ADD_SUCCESS(10000, "插入成功"),
    ADD_FAILED(10001, "插入失败，请重试"),
    ADD_REPEAT(10002, "插入失败，学号已存在，请确认后重试"),

    GET_STUDENT_SUCCESS(10000, "查询成功"),
    GET_STUDENT_FAILED(10001, "查询失败，没有找到学生，请确认后重试"),

    UPDATE_SUCCESS(10000, "修改成功"),
    UPDATE_FAILED(10001, "修改失败"),
    UPDATE_NULL(10002, "修改失败，该学生不存在，请确认后重试"),

    DELETE_SUCCESS(10000, "删除成功"),
    DELETE_FAIL(10001, "删除失败，请重试"),
    DELETE_NULL(10002, "删除失败，该学生不存在，请确认后重试"),

    LOGIN_SUCCESS(10000, "登录成功"),
    LOGIN_FAILED(10001, "登录失败，用户名或密码错误"),
    ;

    private int code;
    private String msg;

    private ResponseStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
