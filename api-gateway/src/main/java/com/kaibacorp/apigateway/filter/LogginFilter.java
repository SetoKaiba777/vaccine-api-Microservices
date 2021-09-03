package com.kaibacorp.apigateway.filter;

import org.slf4j.*;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LogginFilter implements GlobalFilter {

    private Logger logger = (Logger) LoggerFactory.getLogger(LogginFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Original Request Path -> {}",exchange.getRequest().getPath());
        return chain.filter(exchange);
    }
}
