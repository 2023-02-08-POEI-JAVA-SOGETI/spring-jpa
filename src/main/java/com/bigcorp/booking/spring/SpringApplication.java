package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.service.ExampleService;
import com.bigcorp.booking.service.MonControleurWeb;


public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			
//			ExampleService exampleService = appContext.getBean("exampleService", ExampleService.class);
//			exampleService.save(new Example());
			MonControleurWeb monControleurWeb = appContext.getBean("monControleurWeb", MonControleurWeb.class);
			monControleurWeb.getMonService().getMonDao().test();	
			
			}
	}

}