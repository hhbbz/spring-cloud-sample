package com.example.springCloudDecisionSystem.api.v1.controller;

import com.example.springCloudServiceApi.api.v1.feign.DemoServiceFeign;
import com.example.springCloudServiceApi.api.v1.feign.UserServiceFeign;
import com.example.springCloudServiceApi.api.v1.model.DemoModel;
import com.example.springCloudServiceApi.api.v1.model.UserModel;
import com.example.springCloudServiceApi.api.v1.util.StatefulBody;
import com.example.springCloudServiceApi.api.v1.util.SuccessResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceFeign userServiceFeign;

    @Autowired
    private DemoServiceFeign demoServiceFeign;

    @GetMapping("detail")
    @ResponseStatus(HttpStatus.OK)
    public StatefulBody getUserAndDemo(){
        UserModel userModel = this.userServiceFeign.info();
        DemoModel demoModel = this.demoServiceFeign.hello();
        System.out.println("数据聚合："+userModel.getName()+demoModel.getName());
        return SuccessResponseBody.builder().payload(userModel).build();
    }
}
