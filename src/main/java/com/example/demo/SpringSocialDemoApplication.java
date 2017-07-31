package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:properties/social.properties")
public class SpringSocialDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSocialDemoApplication.class, args);
	}
}
