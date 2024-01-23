package com.nhnacademy.edu.springboot.student.controller.login;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession(true).getAttribute("memberId") != null){
            return true;
        }else {
            response.sendRedirect("/login");
            return false;
        }
    }
}
