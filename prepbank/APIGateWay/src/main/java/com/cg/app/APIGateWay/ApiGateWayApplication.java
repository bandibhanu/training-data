package com.cg.app.APIGateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.cg.app.APIGateWay.filter.ErrorFilter;
import com.cg.app.APIGateWay.filter.PostFilter;
import com.cg.app.APIGateWay.filter.PreFilter;
import com.cg.app.APIGateWay.filter.RouteFilter;

@SpringBootApplication
@EnableZuulProxy

public class ApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayApplication.class, args);
	}

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}

