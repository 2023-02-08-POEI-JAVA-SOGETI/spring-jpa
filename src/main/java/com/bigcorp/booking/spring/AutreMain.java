package com.bigcorp.booking.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bigcorp.booking.service.MonControleurWeb;

public class AutreMain {
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext appContext = new
				ClassPathXmlApplicationContext("applicationContext.xml")) {
			
//			ExampleService exampleService = appContext.getBean("exampleService", ExampleService.class);
//			exampleService.save(new Example());
			MonControleurWeb monControleurWeb = appContext.getBean("monControleurWeb", MonControleurWeb.class);
			monControleurWeb.getMonService().getMonDao().test();	
			
			}
	}
}
