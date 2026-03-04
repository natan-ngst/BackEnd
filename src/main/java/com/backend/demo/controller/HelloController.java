package com.backend.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello World";
    }

    @PostMapping
    public String post(){
        return "post mapping";
    }

    @PutMapping
    public String put(){
        return "put mapping";
    }

    @DeleteMapping
    public String delete(){
        return "delete mapping";
    }
}
