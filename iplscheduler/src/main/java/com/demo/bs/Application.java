package com.demo.bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("Contains PlayerService  " + context.containsBeanDefinition("playerService"));
		System.out.println("Contains PlayerController  " + context.containsBeanDefinition("playerController"));
		System.out.println("Contains cityRepository  " + context.containsBeanDefinition("cityRepository"));
		System.out.println("Contains playerRepository  " + context.containsBeanDefinition("playerRepository"));
		System.out.println("Contains teamRepository  " + context.containsBeanDefinition("teamRepository"));
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
	
}
