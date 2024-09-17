package com.java.springcloudgateway.gatewaymicroservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.java.springcloudgateway.gatewaymicroservice.filter.JwtAuthenticationFilter;

@Configuration
public class GatewayConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public GatewayConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("login_route", r -> r.path("/auth/login")
                .uri("http://localhost:8081"))
            .route("validate_route", r -> r.path("/validate")
                .uri("http://localhost:8086"))
            // Handle OPTIONS requests
            .route("preflight_route", r -> r.method("OPTIONS")
                .filters(f -> f.addResponseHeader("Access-Control-Allow-Origin", "http://localhost:8084")
                    .addResponseHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                    .addResponseHeader("Access-Control-Allow-Headers", "*")
                    .addResponseHeader("Access-Control-Allow-Credentials", "true"))
                .uri("no://op"))
            .build();
    }
 
}




