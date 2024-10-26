package com.RViP.gateway.gatewayFilterFactory;

import com.RViP.gateway.jwt.JwtTokenProvider;
import com.RViP.gateway.service.ReaderService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class JwtAuthenticationGatewayFilterFactory extends AbstractGatewayFilterFactory<JwtAuthenticationGatewayFilterFactory.Config> {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private ReaderService readerService;

    public JwtAuthenticationGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            System.out.println(request);
            if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                return unauthorized(exchange);
            }

            String authorizationHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer-")) {
                return unauthorized(exchange);
            }
            System.out.println(authorizationHeader);
            String token = authorizationHeader.substring(7);

            if (!jwtTokenProvider.validateToken(token)) {
                return unauthorized(exchange);
            }
            System.out.println(token);
            Claims claims = jwtTokenProvider.getClaimsFromToken(token);
            UUID uuid = UUID.fromString(claims.get("userId").toString());
            System.out.println(uuid);
            readerService.verifyJwt(uuid);

            return chain.filter(exchange);
        };
    }

    public static class Config {
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

}
