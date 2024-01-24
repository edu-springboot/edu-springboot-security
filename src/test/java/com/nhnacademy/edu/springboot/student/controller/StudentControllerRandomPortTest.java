package com.nhnacademy.edu.springboot.student.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springboot.student.service.Student;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerRandomPortTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @LocalServerPort
    String port;

    @Test
    @DisplayName("학생 전부 조회")
    @Order(1)
    void testGetStudent() throws Exception {
        Student actual = testRestTemplate.getForObject("/students/{id}", Student.class, 2L);
        assertThat(actual.getId()).isEqualTo(2L);

        System.out.println("======>PORT : "+ port);
    }
}