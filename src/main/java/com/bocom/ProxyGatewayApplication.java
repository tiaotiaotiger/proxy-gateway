package com.bocom;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.bocom.filter.AccessFilter;

@SpringCloudApplication
@EnableZuulProxy
public class ProxyGatewayApplication {

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProxyGatewayApplication.class, args);
	}
}
