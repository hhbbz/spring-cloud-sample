package com.example.springCloudDecisionSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(basePackages = "com.example.springCloudServiceApi.api.v1.feign")
@EnableEurekaClient
//@ComponentScan(basePackages = {"main 所在的包","降级类所在的包"})
@ComponentScan(basePackages = {"com.example.springCloudDecisionSystem","com.example.springCloudServiceApi.api.v1.feign.fallback"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringCloudDecisionSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDecisionSystemApplication.class, args);
    }
}
