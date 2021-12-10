package com.jerry.project.domain.member.mapper;

import com.jerry.project.domain.member.model.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<Member> getMembers() throws Exception;

    Member chekLogin(String id, String pw) throws Exception;


}
