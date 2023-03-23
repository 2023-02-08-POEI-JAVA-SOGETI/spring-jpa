package com.bigcorp.booking.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Annotée par @Controller, cette classe va être considérée par Spring MVC pour
 * traiter des requêtes.
 */
@Controller // indique à spring que la classe peut traiter des requetes http
public class Page2Controller {
	/**
	 * Intercepte les requêtes /salut , effectue des instructions (ici un simple
	 * System.out) puis renvoie vers la vue salut.
	 * 
	 * @return
	 */
	@RequestMapping("/page2")
	public String maPage2() {
		System.out.println("Le contrôleur de la page2 agit ! ");
		return "ma-page2";
	}

}