package com.student.information.service.impl;


import com.student.information.db.entity.Admin;
import com.student.information.db.repository.AdminRepository;
import com.student.information.service.LoginService;
import com.student.information.util.Response;
import com.student.information.util.ResponseStatusEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AdminRepository adminRepository;

    @Override
    public Response login(String username, String password, HttpServletRequest request) {
        // 通过用户名在数据库中查找
        Admin admin = adminRepository.findAdmin(username);
        // 不为空则判断密码是否正确
        if (admin != null) {
            if (admin.getPassword().equals(password)) {
                // 密码正确则存入session中
                request.getSession().setAttribute("admin", admin);
                return Response.valueOf(ResponseStatusEnum.LOGIN_SUCCESS);
            } else {
                return Response.valueOf(ResponseStatusEnum.LOGIN_FAILED);
            }
        }
        return Response.valueOf(ResponseStatusEnum.LOGIN_FAILED);
    }
}
