package com.nhnacademy.edu.springboot.student.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

    boolean existsByMemberIdAndPwd(String memberId, String password);
}
