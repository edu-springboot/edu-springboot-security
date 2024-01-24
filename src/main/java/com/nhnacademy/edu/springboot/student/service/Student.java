package com.nhnacademy.edu.springboot.student.service;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Students")
public class Student {
    @Id
    private Long id;
    private String name;
    private Integer score;
}
