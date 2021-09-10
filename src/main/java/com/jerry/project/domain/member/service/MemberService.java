package com.jerry.project.domain.member.service;

import com.jerry.project.domain.member.mapper.MemberMapper;
import com.jerry.project.domain.member.model.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    // db 확인 말고, 우선 id=pw 조건으로 로그인처리 구현
    public Member login(String id, String pw){

        Member member = null;
        if(id.equals(pw)){
            member = new Member();
            member.setId(id);
            member.setPw(pw);
            member.setName("이름");
        }
        return member;
    }


}
