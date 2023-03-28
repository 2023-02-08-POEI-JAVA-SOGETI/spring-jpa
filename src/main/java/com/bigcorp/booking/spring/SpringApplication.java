package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
		
		}
	}

}