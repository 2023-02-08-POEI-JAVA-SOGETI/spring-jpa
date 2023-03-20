package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.service.ExampleService;

public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext 
				= new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			ExampleService exampleService 
				= appContext.getBean("exampleService", ExampleService.class);
			exampleService.findByNom("toto");
		}
		
		//Récupérer une instance de MonControleurWeb 
	
//		try (AnnotationConfigApplicationContext appContext = 
//				new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
//			MonControleurWeb monControleurWeb = appContext.getBean(MonControleurWeb.class);	
//			
//			System.out.println(monControleurWeb.getMonService().getMonDao());
//			monControleurWeb.getMonService().getMonDao().save(null);
//			
//		}
	
	
	}

}