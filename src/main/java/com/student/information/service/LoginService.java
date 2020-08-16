package com.student.information.service;

import com.student.information.util.Response;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    Response login(String username, String password, HttpServletRequest request);
}
