package com.bigcorp.booking.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Annotée par @Controller, cette classe va être considérée par Spring MVC pour
 * traiter des requêtes.
 */
@Controller // indique à spring que la classe peut traiter des requetes http
public class Page1Controller {
	/**
	 * Intercepte les requêtes /salut , effectue des instructions (ici un simple
	 * System.out) puis renvoie vers la vue salut.
	 * 
	 * @return
	 */
	@RequestMapping("/page1")
	public String maPage1() {
		System.out.println("Le contrôleur de la page1 agit ! ");
		return "ma-page1";
	}

}