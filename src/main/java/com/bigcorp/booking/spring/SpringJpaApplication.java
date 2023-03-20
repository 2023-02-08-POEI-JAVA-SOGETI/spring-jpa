package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.service.ExampleService;

public class SpringJpaApplication {

	public static void main(String[] args) {

		// On demarre le contexte de Spring
		// Avec la config de 'SpringConfiguration' qui precise le package à scanner
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
				SpringConfiguration.class)) {
			
			//On récupère les beans se trouvant dans 'ExampleService' dans une variable 'exampleService'
			ExampleService exampleService = appContext.getBean("exampleService", ExampleService.class);
			
			//On recupere les propriétés du modele 'Example' que l'on stock dans la variable example
			Example example = new Example();

			example.setNom("Due le vendredi");

		}

	}
}
