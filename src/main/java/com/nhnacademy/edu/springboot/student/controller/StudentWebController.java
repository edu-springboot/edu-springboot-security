package com.nhnacademy.edu.springboot.student.controller;

import com.nhnacademy.edu.springboot.student.config.StudentProperties;
import com.nhnacademy.edu.springboot.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class StudentWebController {

    private final StudentService studentService;
    private final StudentProperties properties;

    @GetMapping("/web/students/{id}")
    public String getStudent(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.getStudent(id));
        model.addAttribute("name", properties.getName() );
        return "student";
    }
}
