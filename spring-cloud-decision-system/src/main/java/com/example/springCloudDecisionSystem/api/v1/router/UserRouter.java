package com.example.springCloudDecisionSystem.api.v1.router;

import com.example.springCloudDecisionSystem.api.v1.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRouter {
    @Bean
    public RouterFunction<ServerResponse> routeCity(UserHandler UserHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        UserHandler::helloUser);
    }
}
