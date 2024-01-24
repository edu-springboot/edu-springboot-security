package com.nhnacademy.edu.springboot.student.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springboot.student.service.Student;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("학생 전부 조회")
    @Order(1)
    void testGetStudents() throws Exception{
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", equalTo("Manty")));
    }

    @Test
    @DisplayName("1번 학생 조회")
    @Order(2)
    void testGetStudent() throws Exception {
        mockMvc.perform(get("/students/{id}", 2L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo("Manty")));
    }

    @Test
    @DisplayName("4번 학생 등록")
    @Order(3)
    void testCreateStudent() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Student zbum1 = new Student(4L, "zbum1", 100);

        mockMvc.perform(
                post("/students")
                        .content(objectMapper.writeValueAsString(zbum1))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo("zbum1")));
    }

    @Test
    @DisplayName("4번 학생 삭제")
    @Order(4)
    void testDeleteStudent() throws Exception{
        mockMvc.perform(delete("/students/{id}", 4L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result", equalTo("OK")));
    }
}