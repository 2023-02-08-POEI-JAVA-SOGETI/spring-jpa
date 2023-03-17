package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.service.ClasseA;


public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext 
				= new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			ClasseA beanClasseA = appContext.getBean(ClasseA.class);
			beanClasseA.getClasseB().getClasseC().affiche();
		}
	}

}