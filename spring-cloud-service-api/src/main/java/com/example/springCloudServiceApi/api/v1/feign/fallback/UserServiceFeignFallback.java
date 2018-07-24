package com.example.springCloudServiceApi.api.v1.feign.fallback;

import com.example.springCloudServiceApi.api.v1.feign.UserServiceFeign;
import com.example.springCloudServiceApi.api.v1.model.UserModel;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceFeignFallback implements UserServiceFeign {
    @Override
    public UserModel info() {
        throw new RuntimeException("调用UserService失败");
    }
}
