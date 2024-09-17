package com.java.springcloudgateway.gatewaymicroservice.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class JwtAuthenticationGatewayFilter implements GatewayFilter {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public JwtAuthenticationGatewayFilter(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return jwtAuthenticationFilter.filter(exchange, chain);
    }
}
