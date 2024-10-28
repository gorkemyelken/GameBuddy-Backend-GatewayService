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
                        .uri("https://gamebuddy-user-service-04b8e7746067.herokuapp.com/")) // Kullanıcı servisi
                .route("game-service", r -> r.path("/api/v1/games/**")
                        .uri("https://gamebuddy-game-service-1355a6fbfb17.herokuapp.com/")) // Oyun servisi
                .route("matchmaking-service", r -> r.path("/api/v1/matchmaking/**")
                        .uri("https://gamebuddy-matchmaking-service-c814497a7748.herokuapp.com/")) // Eşleştirme servisi
                .route("auth-service", r -> r.path("/api/v1/auth/**")
                        .uri("https://gamebuddy-auth-service-b40a307cb66b.herokuapp.com/")) // Eşleştirme servisi
                .build();
    }
}
