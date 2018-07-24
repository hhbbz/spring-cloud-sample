package com.example.springCloudDemoService.api.v1.controller;

import com.example.springCloudServiceApi.api.v1.feign.UserServiceFeign;
import com.example.springCloudServiceApi.api.v1.model.DemoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @GetMapping("hello")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity hello(){
        return Optional.ofNullable(DemoModel.builder().name("world").build())
                .map(s -> new ResponseEntity<>(s, OK))
                .orElseThrow(() -> new NullPointerException());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity postDemo(String name){
        return Optional.ofNullable("post:"+name)
                .map(s -> new ResponseEntity<>(s, OK))
                .orElseThrow(() -> new NullPointerException());
    }
}
