package com.bigcorp.booking.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.model.Article;
import com.bigcorp.booking.service.ArticleService;
import com.bigcorp.booking.service.ClientService;
import com.bigcorp.booking.service.FournisseurService;
import com.bigcorp.booking.service.UtilisateurService;

//import com.bigcorp.booking.service.MonControleurWeb;
//import com.bigcorp.booking.service.MonService;

public class SpringApplication {

	/*
	 * public static void main(String[] args) { // try
	 * (AnnotationConfigApplicationContext appContext = new
	 * AnnotationConfigApplicationContext(SpringConfiguration.class)) { //
	 * ArticleService articleService = appContext.getBean("articleService",
	 * ArticleService.class); // articleService.save(new Article()); // } // On
	 * demarre le contexte de Spring // Avec la config de 'SpringConfiguration' qui
	 * precise le package à scanner try (AnnotationConfigApplicationContext
	 * appContext = new AnnotationConfigApplicationContext(
	 * SpringConfiguration.class)) { //On récupère les beans se trouvant dans la
	 * class 'MonControleurWeb' qu'on stock dans une variable 'monControleurWeb'
	 * MonControleurWeb monControleurWeb =
	 * appContext.getBean(MonControleurWeb.class);
	 * 
	 * // monService.save(new Article());
	 * 
	 * //Le Bean 'getMonService()' de la classe 'Monservice' injectée par
	 * un @autowired dans la classe 'MonControleurWeb' est appelé ici. //Ensuite le
	 * Bean 'getMonDao()' de la Classe 'MonDao' injectée par un @autowired dans la
	 * classe 'Monservice' est appelé ici. //La sortie de l'instance de MonDao à la
	 * console avec le System.out montre que les injections par un @autowired
	 * fonctionnent.
	 * System.out.println(monControleurWeb.getMonService().getMonDao()); } }
	 */
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
				SpringConfiguration.class)) {
			ArticleService articleService = appContext.getBean("articleService", ArticleService.class);
			articleService.findByNom("article");
			
			
			FournisseurService fournisseurService = appContext.getBean("fournisseurService", FournisseurService.class);
			fournisseurService.findByNom("fournisseur");
			
			
			ClientService clientService = appContext.getBean("clientService", ClientService.class);
			clientService.findByNom("client");
			
			
			UtilisateurService utilisateurService = appContext.getBean("utilisateurService", UtilisateurService.class);
			utilisateurService.findByNom("utilisateur");
			
			
		}
	}

}