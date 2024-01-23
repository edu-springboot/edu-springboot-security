package com.nhnacademy.edu.springboot.student.controller;


import com.nhnacademy.edu.springboot.student.config.SystemProperties;
import com.nhnacademy.edu.springboot.student.model.VersionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SystemController {

    private final SystemProperties systemProperties;

    @GetMapping("/system/version")
    public VersionResponse getVersion() {
        return new VersionResponse(systemProperties.getVersion());
    }
}
