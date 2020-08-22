package com.student.information.controller;

import com.student.information.dto.LoginRequest;
import com.student.information.service.LoginService;
import com.student.information.util.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public Response login(@RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST");
        return loginService.login(loginRequest.getUsername(), loginRequest.getPassword(), request);
    }
}
