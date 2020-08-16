package com.student.information.Interceptor;


import com.student.information.db.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            if (admin != null) {
                return true;
            }
            //response.sendRedirect(request.getContextPath()+"/login");
            response.getWriter().print("{\n" +
                    "    \"code\": 20000\n" +
                    "}");
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
