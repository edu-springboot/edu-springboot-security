package com.nhnacademy.edu.springboot.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public boolean matches(String id, String password) {
        return memberRepository.existsByMemberIdAndPwd(id, password);
    }

}
