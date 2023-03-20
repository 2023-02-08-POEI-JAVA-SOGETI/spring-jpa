package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.model.Client;
import com.bigcorp.booking.service.ClientService;
//import com.bigcorp.booking.model.Example;
//import com.bigcorp.booking.service.ExampleService;
//import com.bigcorp.booking.service.MonControlerWeb;
//import com.bigcorp.booking.tpSpring.MonControlerWebTp;


public class SpringApplication {

	public static void main(String[] args) {
//		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
//			ExampleService exampleService = appContext.getBean("exampleService", ExampleService.class);
//			exampleService.save(new Example());
//		}
//		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
//			MonControlerWeb monControlerWeb = appContext.getBean("monControlerWeb", MonControlerWeb.class);
//			monControlerWeb.getMonService().getMonDao().sayHello();
//		}
//		try (AnnotationConfigApplicationContext appContext 
//				= new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
//			MonControlerWebTp monControlerWebTp = appContext.getBean("monControlerWebTp", MonControlerWebTp.class);
//			monControlerWebTp.getMonServiceTp().getMonDaoTp().sayHello();
//		}
		
		try (AnnotationConfigApplicationContext appContext 
				= new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			ClientService clientService 
				= appContext.getBean("clientService", ClientService.class);
//			clientService.findByNom("Alex");
			clientService.save(new Client());
		}
	}
}