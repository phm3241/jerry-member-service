package com.jerry.project.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value={"com.jerry.project.domain.**.mapper"
        ,"com.jerry.project.test"
})
public class MyBatisConfig {



}