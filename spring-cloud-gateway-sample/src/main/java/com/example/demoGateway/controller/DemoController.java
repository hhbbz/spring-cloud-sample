package com.example.demoGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("hello")
    public String hello(){
        return "hello world,this is gateway";
    }
}
