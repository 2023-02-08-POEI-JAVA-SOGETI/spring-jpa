package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.service.simple.MonControleurWeb;



public class SpringSimpleApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext 
				= new AnnotationConfigApplicationContext(SpringSimpleConfiguration.class)) {
			MonControleurWeb monControleurWeb = appContext.getBean(MonControleurWeb.class);
			monControleurWeb.getMonService().getMonDao().salut();
		}
	}

}