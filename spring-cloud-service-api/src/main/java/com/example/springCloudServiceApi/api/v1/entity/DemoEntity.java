package com.example.springCloudServiceApi.api.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DemoEntity {

    private String name;

    private String password;
}
