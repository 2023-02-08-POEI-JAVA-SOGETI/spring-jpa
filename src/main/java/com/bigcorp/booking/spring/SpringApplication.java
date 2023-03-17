package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.mvc.MonControleurWeb;
import com.bigcorp.booking.service.ExampleService;

public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			//ExampleService exampleService = appContext.getBean("exampleService", ExampleService.class);
			//exampleService.save(new Example());
			
			MonControleurWeb monControleur = appContext.getBean(MonControleurWeb.class);
		}
	}
}