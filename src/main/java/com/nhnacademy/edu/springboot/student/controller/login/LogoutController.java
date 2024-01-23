package com.nhnacademy.edu.springboot.student.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        Optional.ofNullable(request.getSession())
                .ifPresent(HttpSession::invalidate);
        return "redirect:/login";
    }

}
