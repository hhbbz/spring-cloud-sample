# spring-cloud-sample

根据实际应用的业务开发设计的微服务初步架构。

- spring-cloud-eureka-sample 服务注册发现
- spring-cloud-gateway-sample 应用网关
- spring-cloud-decision-system 第二重业务网关(含有webflux demo)，用作数据查询聚合，超时，缓存等处理
- spring-cloud-demo-service 业务逻辑实现模块，主要是分离的各个服务，可以理解为数据仓库
- spring-cloud-user-service 同上
- spring-cloud-service-api 业务模块的接口，以及实体

# 项目大体流程图

![流程图](/MS.jpg)