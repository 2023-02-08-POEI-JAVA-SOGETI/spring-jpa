package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

<<<<<<< HEAD
import com.bigcorp.booking.service.ExampleService;
=======
>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7

public class SpringApplication {

	public static void main(String[] args) {
<<<<<<< HEAD
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
	
	
=======
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			
//			ExampleService exampleService = appContext.getBean("exampleService", ExampleService.class);
//			exampleService.save(new Example());
//			MonControleurWeb monControleurWeb = appContext.getBean("monControleurWeb", MonControleurWeb.class);
//			monControleurWeb.getMonService().getMonDao().test();	
			
			}
>>>>>>> d1663f37c38975a3267ea5eabf24ce1f1d1ce8a7
	}

}