package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.service.MonControleurWeb;


public class SpringApplication {

	public static void main(String[] args) {
//		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
//			ExampleService exampleService = appContext.getBean("exampleService", ExampleService.class);
//			exampleService.save(new Example());
//		}
		
		//Récupérer une instance de MonControleurWeb 
	
		try (AnnotationConfigApplicationContext appContext = 
				new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			MonControleurWeb monControleurWeb = appContext.getBean(MonControleurWeb.class);	
			
//			System.out.println(monControleurWeb.getMonService().getMonDao());
			monControleurWeb.getMonService().getMonDao().affiche(null);
			
		}
//		try (AnnotationConfigApplicationContext appContext = 
//				new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
//			
//			Role role = appContext.getBean(Role.class);
////			System.out.println(monControleurWeb.getMonService().getMonDao());
//			((Role) role.getUsers()).save(new Role());
//			
//		}
//	
	}

}