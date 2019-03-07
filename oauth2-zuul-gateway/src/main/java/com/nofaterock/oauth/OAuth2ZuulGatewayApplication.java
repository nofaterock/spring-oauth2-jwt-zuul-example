package com.nofaterock.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableZuulProxy
public class OAuth2ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2ZuulGatewayApplication.class, args);
	}

}
