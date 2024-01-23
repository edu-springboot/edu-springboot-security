package com.nhnacademy.edu.springboot.student.service;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Members")
public class Member {
    @Id
    @Column(name = "member_id", nullable = false)
    private String memberId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="pwd", nullable = false)
    private String pwd;
}
