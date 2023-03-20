package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.service.simple.ClasseA;

public class SpringJpaApplication {

	public static void main(String[] args) {
		//On démarre le contexte Spring
		//avec la configuration qui se trouve dans SpringConfiguration.class
		try (AnnotationConfigApplicationContext appContext 
				= new AnnotationConfigApplicationContext(
				SpringConfiguration.class)) {
			
			ClasseA beanA = appContext.getBean(ClasseA.class);
			beanA.getClasseB().getClasseC().affiche();
			
		}
	}

}
