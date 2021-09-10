package com.jerry.project.controller.member.param;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
public class MemberLoginParam {

    private String id;
    private String pw;

}
