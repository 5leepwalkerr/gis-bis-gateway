package com.gisbis.gatewayproxy.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder){
      return locatorBuilder
                .routes()
                .route(data -> data
                        .path("/render-data/**")
                        .and()
                        .method(HttpMethod.POST)
                        .filters(filter -> filter
                                .stripPrefix(1))
                        .uri("lb://renderData"))
                .build();
    }
}
