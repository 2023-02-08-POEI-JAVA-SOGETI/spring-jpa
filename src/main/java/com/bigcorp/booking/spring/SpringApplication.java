package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.service.MonControllerWeb;
import com.bigcorp.booking.service.MonDao;
import com.bigcorp.booking.service.MonService;

public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
//			ExampleService exampleService = appContext.getBean("exampleService", ExampleService.class);
//			exampleService.save(new Example());
			
//			appContext.register(MonControllerWeb.class);
//			appContext.register(MonDao.class);
//			appContext.register(MonService.class);

			MonControllerWeb monControllerWeb = appContext.getBean(MonControllerWeb.class);
			
			monControllerWeb.getMonService().getMonDao().affiche();
		}
	}

}