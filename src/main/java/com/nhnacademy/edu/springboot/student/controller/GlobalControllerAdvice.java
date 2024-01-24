package com.nhnacademy.edu.springboot.student.controller;

import com.nhnacademy.edu.springboot.student.model.CommonResultResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(Exception.class)
    public CommonResultResponse handleException(Exception exception) {
        CommonResultResponse commonResultResponse = new CommonResultResponse();
        commonResultResponse.setMessage(exception.getMessage());
        return commonResultResponse;
    }
}
