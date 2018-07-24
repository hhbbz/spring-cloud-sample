package com.example.springCloudServiceApi.api.v1.feign;

import com.example.springCloudServiceApi.api.v1.feign.fallback.DemoServiceFeignFallback;
import com.example.springCloudServiceApi.api.v1.model.DemoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "demo-service", fallback = DemoServiceFeignFallback.class)
public interface DemoServiceFeign {
    @RequestMapping(method = RequestMethod.GET,path = "/demo/hello")
    DemoModel hello();
}
