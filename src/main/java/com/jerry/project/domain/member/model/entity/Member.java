package com.jerry.project.domain.member.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * entity -
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {

    private String name;
    private String id;
    private String pw;


}
