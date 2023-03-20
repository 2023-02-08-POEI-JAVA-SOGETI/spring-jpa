package exercice1_spring.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.model.Example;
import com.bigcorp.booking.service.ExampleService;


//import com.bigcorp.booking.service.MonControleurWeb;
//import com.bigcorp.booking.service.MonService;
import exercice1_spring.service.MonControleurWeb;

public class SpringApplication {

	public static void main(String[] args) {
//		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
//			ExampleService exampleService = appContext.getBean("exampleService", ExampleService.class);
//			exampleService.save(new Example());
//		}
		// On demarre le contexte de Spring
		// Avec la config de 'SpringConfiguration' qui precise le package à scanner
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
				SpringConfiguration.class)) {
			// On récupère les beans se trouvant dans la class 'MonControleurWeb' qu'on
			// stock dans une variable 'monControleurWeb'
			MonControleurWeb monControleurWeb = appContext.getBean(MonControleurWeb.class);

			// monService.save(new Example());

			// Le Bean 'getMonService()' de la classe 'Monservice' injectée par un
			// @autowired dans la classe 'MonControleurWeb' est appelé ici.
			// Ensuite le Bean 'getMonDao()' de la Classe 'MonDao' injectée par un
			// @autowired dans la classe 'Monservice' est appelé ici.
			// La sortie de l'instance de MonDao à la console avec le System.out montre que
			// les injections par un @autowired fonctionnent.
			System.out.println(monControleurWeb.getMonService().getMonDao());
		}
	}

}