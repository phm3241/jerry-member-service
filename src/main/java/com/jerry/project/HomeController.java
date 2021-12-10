package com.jerry.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping("/hello")
    public String Hello() {
        return "hello~ jerry project !";
    }





}
