package com.jerry.project.config;

import com.jerry.project.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.Filter;

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
//                .allowedOrigins("*")
//                .allowedOriginPatterns("*")
                .allowedOriginPatterns("http://localhost:3030")
                .allowedMethods("*")
                .allowCredentials(true);
    };

    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }


//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    };
//
//    @Bean
//    public CharacterEncodingFilter characterEncodingFilter() {
//        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//        return characterEncodingFilter;
//    };
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // registry.addResourceHandler("swagger-ui.html")
//        // .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }


}