package com.bigcorp.booking.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Annotée par @Controller, cette classe va être considérée par Spring MVC pour
 * traiter des requêtes.
 */
@Controller // indique à spring que la classe peut traiter des requetes http
public class PageAcceuilController {
	/**
	 * Intercepte les requêtes /salut , effectue des instructions (ici un simple
	 * System.out) puis renvoie vers la vue salut.
	 * 
	 * @return
	 */

	// Mapping de la page d'acceuil
	@RequestMapping("/pageacceuil")
	public String monPageAcceuil() {
		System.out.println("Le contrôleur de la page d'acceuil a agit ! ");
		return "page-acceuil";
	}

	// Message dynamique à l'aide d'un attribut d'un tag et d'une expression
	@ModelAttribute("monMessage")
	public String voiciMonMessage() {
		return "Ce message est chargé dans un attribut 'monMessage à partir du controlleur de la page d'acceuil. L'attribut est chargé dans context à partir du template (page html) de la page d'acceuil de thymlif à l'aide du tag 'th:text=' et de l'expression syntax '${}.Ainsi l'attribut 'monMessage' a permis d'afficher du texte de façon dynamique dans la page html";
	}

	@ModelAttribute("camion1")
	public Camion monCamion1() {
		Camion camion = new Camion();
		camion.setNom("Le premier camion est un Volvo");
		camion.setId(1);
		camion.setDescription("Plus solide qu'un Volvo nexiste pas! ");
		return camion;
	}

	// Exercice if et loop pour Thymeleaf
	@ModelAttribute("toto")
	public Boolean monBoolean() {
		Boolean toto = true;
		return toto;
	}

	@ModelAttribute("iterable")
	public List<String> monIterable() {
		List<String> iterable = new ArrayList<>();
		iterable.add("Modou va au marché");
		iterable.add("Sidi va à l'école ");
		iterable.add("Tonton simon est dans la chambre avec tata rose");
		return iterable;
	}

	@ModelAttribute("listCamion")

	public List<Camion> mesCamions() {
		List<Camion> listCamion = new ArrayList<>();

		Camion camion6 = new Camion();
		camion6.setNom("Volvo");

		Camion camion2 = new Camion();
		camion2.setNom("Scania");

		Camion camion3 = new Camion();
		camion3.setNom("Renault");

		Camion camion4 = new Camion();
		camion4.setNom("Mercedez");

		Camion camion5 = new Camion();
		camion5.setNom("Man");

		listCamion.add(camion6);
		listCamion.add(camion2);
		listCamion.add(camion3);
		listCamion.add(camion4);
		listCamion.add(camion5);
		return listCamion;
	}

}