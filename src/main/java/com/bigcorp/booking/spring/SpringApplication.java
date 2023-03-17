package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.service.MonControleurWeb;
import com.bigcorp.booking.service.MonDao;


public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			MonControleurWeb monControleurWeb = appContext.getBean(MonControleurWeb.class);
			
			monControleurWeb.getMonService().getMonDao().getText();
			
			MonDao monDao = monControleurWeb.getMonService().getMonDao();
			String text = monDao.getText();
			System.out.println();
			System.out.println();
			System.out.println(text.toUpperCase());
			System.out.println();
			System.out.println(monControleurWeb.getMonService().getMonDao().getText());
			System.out.println();			
			System.out.println();			
		
		}
	}

}