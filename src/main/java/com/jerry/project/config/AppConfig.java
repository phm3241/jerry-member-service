package com.jerry.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 스프링 MVC 구성 제어권한 가지기
 * @Configuration 과 @EnableWebMvc를 함께 선언.
 * @EnableWebMvc를 선언하면 WebMvcConfigurationSupport에서 구성한 스프링 MVC 구성을 불러온다.
 * 아래에 선언한 클래스에 WebMvcConfigurer 인터페이스 구현.
 */
@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    @Bean
    MappingJackson2JsonView jsonView(){
        return new MappingJackson2JsonView();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    };

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    };

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    };


}