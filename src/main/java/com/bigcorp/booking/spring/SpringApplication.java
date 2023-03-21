package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.bigcorp.booking.service.simple.MonControllerWeb;
import com.bigcorp.booking.service.simple.MonDao;
import com.bigcorp.booking.service.simple.MonService;

public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringSimpleConfiguration.class)) {
//			ExampleService exampleService = appContext.getBean("exampleService", ExampleService.class);
//			exampleService.save(new Example());

			MonControllerWeb monControllerWeb = appContext.getBean(MonControllerWeb.class);
			
			monControllerWeb.getMonService().getMonDao().affiche();
		}
	}

}