package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.service.simple.ClasseA;


public class SpringSimpleApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext 
				= new AnnotationConfigApplicationContext(SpringSimpleConfiguration.class)) {
			ClasseA beanClasseA = appContext.getBean(ClasseA.class);
			beanClasseA.getClasseB().getClasseC().affiche();
		}
	}

}