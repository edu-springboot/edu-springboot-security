package com.nhnacademy.edu.springboot.student.controller;


import com.nhnacademy.edu.springboot.student.management.MyHealthIndicator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManagementController {
    private final MyHealthIndicator myHealthIndicator;

    @PostMapping("management/fail")
    public String managementFail() {
        myHealthIndicator.setHealth(false);
        return "health has set as fail";
    }
}
