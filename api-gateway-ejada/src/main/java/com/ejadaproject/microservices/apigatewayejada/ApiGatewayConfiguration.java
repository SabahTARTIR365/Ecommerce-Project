package com.ejadaproject.microservices.apigatewayejada;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter (RouteLocatorBuilder builder) {

	return builder.routes()
	//.route(routeFunction)
	.route(p -> p.path("/get")
			     .filters(f -> f.addRequestHeader("MyHeader", "MyURI")
					            .addRequestParameter("Param", "MyValue"))
	                            .uri("http://httpbin.org:80"))
	
	.route(p -> p.path("/order-service/**")
			.uri("lb://order-service"))
	.route(p -> p.path("/shop-service/**")
			.uri("lb://shop-service"))
	
	.route(p -> p.path("/inventory-service/**")
			.uri("lb://inventory-service"))
	.route(p -> p.path("/wallet-service/**")
			.uri("lb://wallet-service"))
    .route("login_route", r -> r
            .path("/login")
            .uri("lb://wallet-service"))
	
    .route(r -> r.path("/swagger-ui/**")
            .filters(f -> f.rewritePath("/swagger-ui/(?<segment>.*)", "/swagger-ui/${segment}"))
            .uri("lb://order-service")
    )

	.build();
	}
	
}
