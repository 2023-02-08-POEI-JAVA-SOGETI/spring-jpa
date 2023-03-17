package com.bigcorp.booking.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bigcorp.booking.mvc.MonControleurWeb;

public class MainSpringApplication {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext appContext = new 
				ClassPathXmlApplicationContext("springContextOld.xml")) {
			MonControleurWeb monControleur = (MonControleurWeb) appContext.getBean("monControleurWeb");
			monControleur.sayHello();
		}
	}
}
