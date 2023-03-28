package com.bigcorp.booking.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Annotée par @Controller, cette classe va être considérée par Spring MVC pour
 * traiter des requêtes.
 */
@Controller // indique à spring que la classe peut traiter des requetes http
public class Page2Controller {
	/**
	 * Intercepte les requêtes /page2/{idCamion1} , attend le paramètre "idCamion1"
	 * dans le chemin et le met dans l'argument idCamion1 de la méthode.
	 * 
	 * @return
	 */
//	@RequestMapping("/page2/{idCamion1}")
//	public String maPage2(@PathVariable("idCamion1") Integer idCamion1) {
//		System.out.println("Le contrôleur de la page2 agit et sa methode @PathVariable a recupere le parametre url idCamion1 :"+idCamion1);
//		return "ma-page2";
//	}


	// La même chose que ci-dessus mais avec un ModelAndView
	@RequestMapping("/page2/{idCamion1}")
	public ModelAndView maPage1(@PathVariable("idCamion1") Integer idCamion1) {
		System.out.println(
				"Le contrôleur de la page2 agit et sa methode @RequestParam a recupere l'attribut de requete idCamion1 : "
						+ idCamion1);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ma-page2");
		modelAndView.addObject("camion", "Le contenu le l'objet est ce string même");
		
		return modelAndView;
	}

}