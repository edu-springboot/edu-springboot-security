package com.nhnacademy.edu.springboot.student.controller.login;

import com.nhnacademy.edu.springboot.student.model.login.LoginRequest;
import com.nhnacademy.edu.springboot.student.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute LoginRequest loginRequest,
                          HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if ( memberService.matches(loginRequest.getId(), loginRequest.getPwd())){
            session.setAttribute("memberId", loginRequest.getId());
            return "redirect:/welcome";
        }
        return "redirect:/login";

    }

}
