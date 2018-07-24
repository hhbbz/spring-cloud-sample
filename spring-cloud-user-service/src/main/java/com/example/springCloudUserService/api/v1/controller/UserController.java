package com.example.springCloudUserService.api.v1.controller;

import com.example.springCloudServiceApi.api.v1.feign.DemoServiceFeign;
import com.example.springCloudServiceApi.api.v1.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private DemoServiceFeign demoServiceFeign;

    @GetMapping("info")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity info(){
        return Optional.ofNullable(UserModel.builder().name("info").build())
                .map(s -> new ResponseEntity<>(s, OK))
                .orElseThrow(() -> new NullPointerException());
    }
}
