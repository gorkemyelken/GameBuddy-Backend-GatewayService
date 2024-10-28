package com.gamebuddy.GatewayService.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/api/v1/users/**")
                        .uri("http://localhost:8081")) // Kullanıcı servisi
                .route("game-service", r -> r.path("/api/v1/games/**")
                        .uri("http://localhost:8082")) // Oyun servisi
                .route("matchmaking-service", r -> r.path("/api/v1/matchmaking/**")
                        .uri("http://localhost:8083")) // Eşleştirme servisi
                .route("auth-service", r -> r.path("/api/v1/auth/**")
                        .uri("http://localhost:8084")) // Eşleştirme servisi
                .build();
    }
}
