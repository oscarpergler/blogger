package com.gateway.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r
						.path("/user/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://USER-SERVICE")) // user-service: port 8082
				.route(p -> p
						.path("/post/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://POSTS-SERVICE")) // posts-service: port 8083
				.build();
	}
}
