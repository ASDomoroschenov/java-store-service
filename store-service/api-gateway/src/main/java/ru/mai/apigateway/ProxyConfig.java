package ru.mai.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyConfig {

    @Bean
    public RouteLocator routs(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(path -> path
                        .path("/store-service/api/product-service/**")
                        .filters(filter -> filter.stripPrefix(2))
                        .uri("lb://product-service"))
                .route(path -> path
                        .path("/store-service/api/inventory-service/**")
                        .filters(filter -> filter.stripPrefix(2))
                        .uri("lb://inventory-service"))
                .route(path -> path
                        .path("/store-service/api/order-service/**")
                        .filters(filter -> filter.stripPrefix(2))
                        .uri("lb://order-service"))
                .build();
    }

}
