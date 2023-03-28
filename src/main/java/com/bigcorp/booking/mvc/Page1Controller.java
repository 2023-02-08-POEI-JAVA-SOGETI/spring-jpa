package com.bigcorp.booking.mvc;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Annotée par @Controller, cette classe va être considérée par Spring MVC pour
 * traiter des requêtes.
 */
@Controller // indique à spring que la classe peut traiter des requetes http
public class Page1Controller {
	
	/**
	 * Intercepte les requêtes /page1 , attend le paramètre de requête "idCamion1" et le
	 * met dans l'argument idCamion1 de la méthode..
	 * @return
	 */
//	@RequestMapping("/page1")
//	public String maPage1(@RequestParam("idCamion1") Integer idCamion1) {
//		System.out.println("Le contrôleur de la page1 agit et sa methode @RequestParam a recupere l'attribut de requete idCamion1 : "+idCamion1);
//		return "ma-page1";
//	}
	//La même chose que ci-dessus mais avec un ModelAndView
	@RequestMapping("/page1")
	public ModelAndView maPage1(@RequestParam("idCamion1") Integer idCamion1) {
		System.out.println("Le contrôleur de la page1 agit et sa methode @RequestParam a recupere l'attribut de requete idCamion1 : "+idCamion1);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ma-page1");
		//ajout d'objets 'message' et 'date'
		modelAndView.addObject("message", "Bonjour ! Bienvenue sur notre site !");
		 modelAndView.addObject("date", new Date());
		
		return modelAndView;
	}

}