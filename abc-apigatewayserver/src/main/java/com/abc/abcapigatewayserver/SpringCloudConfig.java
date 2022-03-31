package com.abc.abcapigatewayserver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig
{
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
                .route("customerModule", rt -> rt.path("/getCustomers/**")
                        .uri("http://localhost:8082/"))
                .route("vendorModule", rt -> rt.path("/vendor/**")
                        .uri("http://localhost:8081/"))
                .build();

    }
}