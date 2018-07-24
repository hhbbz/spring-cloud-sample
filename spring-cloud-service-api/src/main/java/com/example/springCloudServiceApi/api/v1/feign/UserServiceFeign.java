package com.example.springCloudServiceApi.api.v1.feign;

import com.example.springCloudServiceApi.api.v1.feign.fallback.UserServiceFeignFallback;
import com.example.springCloudServiceApi.api.v1.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "user-service", fallback = UserServiceFeignFallback.class)
public interface UserServiceFeign {
    @RequestMapping(method = RequestMethod.GET,path = "/user/info")
    UserModel info();
}
