package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.service.MonDao;
import com.bigcorp.booking.service.MonControlleurWeb;
import com.bigcorp.booking.service.MonService;


public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			MonControlleurWeb monControlleurWeb = appContext.getBean("monControlleurWeb", MonControlleurWeb.class);
			System.out.println(monControlleurWeb.getMonService().getMonDao());
			
		}
	}

}