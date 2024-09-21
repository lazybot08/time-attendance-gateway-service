package com.wipro.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wipro.security.AuthenticationFilter;

@Configuration
public class GatewayConfig {
	
	@Autowired
	private AuthenticationFilter filter;
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/api/v1/auth/**")
						.filters(f -> f.filter(filter))
						.uri("lb://AUTHENTICATION-SERVICE")
						)
				.route(r -> r.path("/api/v1/attendance/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://AUTHENTICATION-SERVICE")
                        )
				.route(r -> r.path("/api/v1/request/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://AUTHENTICATION-SERVICE")
                        )
				.route(r -> r.path("/api/v1/requests/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://REQUEST-SERVICE")
                        )
				.route(r -> r.path("/api/v1/entry/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://TIME-TRACKING-SERVICE")
                        )
                .build();
	}
}
