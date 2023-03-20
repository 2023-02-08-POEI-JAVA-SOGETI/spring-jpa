package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.mvc.MonControleurWeb;
import com.bigcorp.booking.service.MonSpringDao;


public class SpringApplication {

	public static void main(String[] args) {
		// Test anotation Spring
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			MonControleurWeb monControleurWeb = appContext.getBean(MonControleurWeb.class);
			
			monControleurWeb.getMonService().getMonSpringDao().getText();
			
			MonSpringDao monSpringDao = monControleurWeb.getMonService().getMonSpringDao();
			String text = monSpringDao.getText();
			System.out.println();
			System.out.println();
			System.out.println(text.toUpperCase());
			System.out.println();
			System.out.println(monControleurWeb.getMonService().getMonSpringDao().getText());
			System.out.println();			
			System.out.println();			
		
		}
		
		

	    
	    
		
	}

}