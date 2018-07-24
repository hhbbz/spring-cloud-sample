package com.example.springCloudDemoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(basePackages = "com.example.springCloudServiceApi.api.v1.feign")
@EnableEurekaClient
//@ComponentScan(basePackages = {"main 所在的包","降级类所在的包"})
@ComponentScan(basePackages = {"com.example.springCloudDemoService","com.example.springCloudServiceApi.api.v1.feign.fallback"})
@SpringBootApplication
public class SpringCloudDemoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoServiceApplication.class, args);
    }
}
