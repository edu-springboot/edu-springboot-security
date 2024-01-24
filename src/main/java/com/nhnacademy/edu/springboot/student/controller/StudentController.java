package com.nhnacademy.edu.springboot.student.controller;

import com.nhnacademy.edu.springboot.student.model.CommonResultResponse;
import com.nhnacademy.edu.springboot.student.model.DeleteResponse;
import com.nhnacademy.edu.springboot.student.service.Student;
import com.nhnacademy.edu.springboot.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public DeleteResponse deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return new DeleteResponse("OK");
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonResultResponse handleException(NoSuchElementException exception) {
        CommonResultResponse commonResultResponse = new CommonResultResponse();
        commonResultResponse.setMessage(exception.getMessage());
        return commonResultResponse;
    }
}
