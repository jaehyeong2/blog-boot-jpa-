package com.jaeh.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요~";
    }

    @PostMapping("/post")
    public String postreq() {
        return "안될걸?";
    }
}
