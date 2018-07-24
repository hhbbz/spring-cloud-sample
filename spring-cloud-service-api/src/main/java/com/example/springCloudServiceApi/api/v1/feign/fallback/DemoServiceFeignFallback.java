package com.example.springCloudServiceApi.api.v1.feign.fallback;

import com.example.springCloudServiceApi.api.v1.feign.DemoServiceFeign;
import com.example.springCloudServiceApi.api.v1.model.DemoModel;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoServiceFeignFallback implements DemoServiceFeign {

    @Override
    public DemoModel hello() {
        throw new RuntimeException("调用DemoService失败");
    }
}
